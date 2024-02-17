import java.io.PrintWriter;
import java.util.Scanner;

public class ABC341D {

    private static void solve() {
        long n = nextLong();
        long m = nextLong();
        long k = nextLong();
        long lcm = lcm(n, m);
        long nCount = lcm / n - 1;
        long mCount = lcm / m - 1;

        long base = k/(nCount+mCount) * lcm;
        k %= (nCount+mCount);

        if (k == 0) {
            System.out.println(base - Math.min(n, m));
            return;
        }

        long ng = lcm;
        long ok = 0;
        while (Math.abs(ng-ok)>1) {
            long mid = (ok+ng)/2;
            long ex = Math.min((mid+n-1)/n*n, (mid+m-1)/m*m);
            if (ex/n + ex/m <= k) {
                ok = mid;
            } else {
                ng = mid;
            }
        }

        out.println(base + ok);
        out.flush();
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static double nextDouble() { return Double.parseDouble(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}