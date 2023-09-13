import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC319D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        long[] l = nextLongArray(n);
        long max = Arrays.stream(l).max().getAsLong();
        long ng = max-1;
        long ok = Long.MAX_VALUE/2;
        while (ok-ng > 1) {
            long w = (ok+ng)/2;
            long current = l[0];
            int line = 1;
            for (int i = 1; i < n; i++) {
                long li = l[i];
                if (current+1+li > w) {
                    current = li;
                    line++;
                } else {
                    current += 1+li;
                }
            }
            if (line <= m) {
                ok = w;
            } else {
                ng = w;
            }

        }
        out.println(ok);
        out.flush();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> System.exit(1));
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