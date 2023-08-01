import java.io.PrintWriter;
import java.util.Scanner;

public class ABC234F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        String s = next();
        int[] lCount = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lCount[s.charAt(i)-'a']++;
        }

        long[] fact = new long[n+2];
        fact[0]=1;
        fact[1]=1;
        for (int i = 2; i < n + 2; i++) {
            fact[i] = fact[i-1]*i%MOD;
        }
        long[] modInv = new long[n+2];
        for (int i = 0; i < n + 2; i++) {
            modInv[i] = modPow(fact[i], MOD-2, MOD);
        }

        long[][] dp = new long[26][n+1];
        for (int i = 0; i < 26; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= lCount[0]; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < 26; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[i][j] = dp[i-1][j];
            }
            int count = lCount[i];
            for (int j = 0; j < n+1-count; j++) {
                for (int k = 1; k <= count; k++) {
                    long mul = fact[j+k] * modInv[j] % MOD * modInv[k] % MOD;
                    dp[i][k+j] += dp[i-1][j]*mul%MOD;
                    dp[i][k+j] %= MOD;
                }
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp[25][i]) % MOD;
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