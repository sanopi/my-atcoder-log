import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC338C {

    private static final int MAX = 1000000;

    private static void solve() {
        int n = nextInt();
        int[] q = nextIntArray(n);
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        int ans = 0;
        for (int aCount = 0; aCount <= MAX; aCount++) {
            long[] tmpQ = new long[n];
            for (int i = 0; i < n; i++) {
                tmpQ[i] = q[i];
            }
            for (int i = 0; i < n; i++) {
                tmpQ[i] -= (long) a[i] *aCount;
            }
            if (Arrays.stream(tmpQ).filter(i -> i<0).count() > 0) break;
            int ok = 0;
            int ng = MAX+1;
            while (ng - ok > 1) {
                int bCount = (ok+ng)/2;
                long[] tmptmpQ = new long[n];
                for (int i = 0; i < n; i++) {
                    tmptmpQ[i] = tmpQ[i];
                }
                for (int i = 0; i < n; i++) {
                    tmptmpQ[i] -= (long) b[i] *bCount;
                }
                if (Arrays.stream(tmptmpQ).filter(i -> i<0).count() == 0) {
                    ok = bCount;
                } else {
                    ng = bCount;
                }
            }
            ans = Math.max(ans, aCount+ok);
        }
        out.println(ans);
        out.flush();
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