import java.io.PrintWriter;
import java.util.Scanner;

public class ABC333F {

    private static final int MOD = 998244353;

    private static void solve() {
        int n = nextInt();
        long div2 = modPow(2, MOD-2, MOD);
        // i人目までいるとき、j人目が最後のひとりになる確率
        long[][] dp = new long[n][n];
        dp[0][0] = 1;
        long div = div2;
        for (int i = 1; i < n; i++) {
            div = div * div2 % MOD;
            long inv = modPow((1-div+MOD)%MOD, MOD-2, MOD);

            long sum = 0;
            long tmpDiv = div2;
            for (int j = i-1; j >= 0; j--) {
                tmpDiv = tmpDiv * div2 % MOD;
                sum = (sum + tmpDiv * dp[i-1][j])%MOD;
            }

            dp[i][0] = sum*inv%MOD;

            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j-1]) * div2 % MOD;
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(dp[n - 1][i] + " ");
        }

        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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