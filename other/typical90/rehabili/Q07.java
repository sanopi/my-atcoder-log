import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q07 {

    private static void solve() {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Arrays.sort(a);

        int q = nextInt();
        while (q --> 0) {
            int b = nextInt();
            int found = lowerBound(a, b);
            out.println(Math.min(
                    Math.abs(a[Math.max(0, found - 1)] - b),
                    Math.abs(a[Math.min(n-1, found)] - b)
            ));

        }

        out.flush();
    }

    private static int lowerBound(int[] a, int key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key <= a[mid]) {
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