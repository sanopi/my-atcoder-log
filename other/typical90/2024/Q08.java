import java.io.PrintWriter;
import java.util.Scanner;

public class Q08 {

    private static final int MOD = 1000000007;
    private static final String ATCODER = "atcoder";
    private static final int LEN = ATCODER.length();

    private static void solve() {
        int n = nextInt();
        String s = next();
        long[][] dp = new long[LEN+1][n];
        dp[0][0] = 1;
        if (s.charAt(0) == ATCODER.charAt(0)) {
            dp[1][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            char si = s.charAt(i);
            for (int j = 0; j < LEN + 1; j++) {
                dp[j][i] = dp[j][i-1];
            }
            for (int j = 0; j < LEN; j++) {
                if (ATCODER.charAt(j) == si) {
                    dp[j+1][i] += dp[j][i-1];
                    dp[j+1][i] %= MOD;
                }
            }
        }
        out.println(dp[LEN][n-1]);
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