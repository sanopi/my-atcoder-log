import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC150D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int ai = nextInt();
            a[i] = ai/2;
        }

        long lcm = 1;
        for (int i = 0; i < n; i++) {
            lcm = lcm(lcm, a[i]);
            if (lcm > m) {
                System.out.println(0);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (lcm / a[i] % 2 == 0) {
                System.out.println(0);
                return;
            }
        }
        m-=lcm;
        out.println(m/(2*lcm)+1);
        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 16 * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> e.printStackTrace());
        thread.start();
        out.flush();
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