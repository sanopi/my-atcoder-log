import java.io.PrintWriter;
import java.util.Scanner;

public class ABC162E {

    private static int MOD = 1000000007;

    private static void solve() {
        int n = nextInt();
        int k = nextInt();

        long[] dp = new long[k+1];
        long[] memo = new long[k+1];
        dp[k] = 1;
        for (int i = k-1; i > 0; i--) {
            if (memo[k / i] != 0) {
                dp[i] = memo[k / i];
            }
            else {
                dp[i] = modPow(k / i, n, MOD);
                memo[k/i] = dp[i];
            }
            for (int j = i*2; j <= k; j+=i) {
                dp[i] -= dp[j];
                dp[i] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = (ans + dp[i]*i)%MOD;
        }
        ans = (ans+MOD)%MOD;
        out.println(ans);
        out.flush();
    }

    private static long modPow(long a, long n, long mod) {
        long x = a % mod;
        long res = 1;
        while (n > 0) {
            if ((n&1) == 1) {
                res = res * x % mod;
            }
            n = n >> 1;
            x = x*x % mod;
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
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus ? 1 : 0;
        for (int i = start; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }
        return minus ? -res : res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus ? 1 : 0;
        for (int i = start; i < chars.length; i++) {
            res = res * 10 + (chars[i] - '0');
        }
        return minus ? -res : res;
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}