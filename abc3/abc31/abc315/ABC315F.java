import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC315F {

    private static void solve() {
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            pairs[i] = new Pair(x, y);
        }
        double[][] dp = new double[n][30];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Double.POSITIVE_INFINITY);
        }
        dp[0][0] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = Math.max(0, i-30); j < i; j++) {
                for (int k = 0; k+(i-j-1) < 30; k++) {
                    int skip = k + (i - j - 1);
                    double minus = calcPena(k);
                    double plus = calcPena(skip);
                    dp[i][skip] = Math.min(
                        dp[i][skip],
                        dp[j][k] + pairs[i].dist(pairs[j]) - minus + plus
                    );
                }
            }
        }

        double ans = Double.POSITIVE_INFINITY;
        for (int i = 0; i < 30; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        out.println(ans);
        out.flush();
    }

    private static double calcPena(int c) {
        return c == 0 ? 0 : 1<<(c-1);
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private double dist(Pair other) {
            long xd = other.x-this.x;
            long yd = other.y-this.y;
            return Math.sqrt(xd*xd+yd*yd);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {e.printStackTrace();System.exit(1);});
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