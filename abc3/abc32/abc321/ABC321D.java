import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC321D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        long p = nextInt();
        long[] a = nextLongArray(n);
        long[] b = nextLongArray(m);
        Arrays.sort(a);
        Arrays.sort(b);
        long[] aSum = new long[n+1];
        for (int i = 0; i < n; i++) {
            aSum[i+1] = aSum[i] + a[i];
        }
        long[] bSum = new long[m+1];
        for (int i = 0; i < m; i++) {
            bSum[i+1] = bSum[i] + b[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            int found = upperBound(b, p-ai);
            ans += p*(m-found) + ai*found + (bSum[found]);
        }
        out.println(ans);
        out.flush();
    }

    private static int upperBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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