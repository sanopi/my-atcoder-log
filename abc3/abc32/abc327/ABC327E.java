import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC327E {

    private static void solve() {
        int n = nextInt();
        int[] p = nextIntArray(n);
        double[] divs = new double[n+2];
        divs[0] = 1;
        for (int i = 1; i < n+2; i++) {
            divs[i] = divs[i-1] * 0.9;
        }

        // i個目まで（後ろから）見て、j個選んでる時の、分子の最大値
        double[][] dp = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[n-1][0] = 0;
        dp[n-1][1] = p[n-1];
        for (int i = n - 2; i >= 0; i--) {
            int pi = p[i];
            for (int j = 0; j < n; j++) {
                if (dp[i+1][j] == -1) break;
                dp[i][j] = Math.max(dp[i][j], dp[i+1][j]);
                dp[i][j+1] = Math.max(dp[i][j+1], dp[i+1][j]+pi*divs[j]);
            }
        }
        double ans = Double.NEGATIVE_INFINITY;
        double div = 1;
        for (int i = 1; i < n+1; i++) {
            double value = dp[0][i];
            if (value == -1) continue;
            ans = Math.max(ans, value/div-(1200/Math.sqrt(i)));
            div += divs[i];
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