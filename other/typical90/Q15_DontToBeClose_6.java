import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q15_DontToBeClose_6 {

    private static final int MOD = 1000000007;
    private static long[] ruijo;
    private static long[] ruijo_gyakugen;

    public static void main(String[] args) {
        int n = nextInt();

        ruijo = new long[n+1];
        ruijo_gyakugen = new long[n+1];
        ruijo[0] = 1;
        ruijo_gyakugen[0] = modPow(ruijo[0], MOD-2, MOD);
        for (int i = 1; i <= n; i++) {
            ruijo[i] = ruijo[i-1] * i % MOD;
            ruijo_gyakugen[i] = modPow(ruijo[i], MOD-2, MOD);
        }

        // 差がk以上を考える
        for (int k = 1; k <= n; k++) {
            int maxBallCount = (n-1) / k + 1;
            // ボールをj個選ぶことを考える
            long result = 0;
            for (int j = 1; j <= maxBallCount; j++) {
                int count = n - (k-1)*(j-1);
                result += modCombination(count, j, MOD);
                result %= MOD;
            }
            out.println(result);
        }
        out.flush();
    }

    private static long modCombination(int n, int k, int mod) {
        if (n<k) return 0;
        long numerator = ruijo[n];
        long denominator = ruijo_gyakugen[k] * ruijo_gyakugen[n-k] % mod;
        return numerator * denominator % mod;
    }

    private static long modFact(long from, long toEx, int mod) {
        if (from == toEx) {
            return 1;
        }
        return from * modFact(from-1, toEx, mod) % mod;
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