import java.io.PrintWriter;
import java.util.Scanner;

public class ABC310F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        long[][] dp = new long[n+1][1<<11];
        for (int i = 0; i < n; i++) {
            dp[0][1] = 1;
        }
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            long aiInv = modPow(ai, MOD-2, MOD);

            for (int j = 1; j < 1 << 11; j++) {
                // 1-10の値が出る場合
                for (long k = 1; k <= Math.min(ai, 10); k++) {
                    int or = j | (j<<k);
                    or &= (1<<11)-1;
                    dp[i+1][or] += dp[i][j]*aiInv;
                    dp[i+1][or]%=MOD;
                }
                // 11以上の値が出る場合
                dp[i+1][j] += dp[i][j]* Math.max(0, ai-10) %MOD * aiInv;
                dp[i+1][j] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i < 1 << 11; i++) {
            if ((i & (1<<10)) != 0) {
                ans = (ans + dp[n][i]) % MOD;
            }
        }
        out.println(ans);
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