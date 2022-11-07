import java.io.PrintWriter;
import java.util.Scanner;

public class ABC224F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        char[] chars = s.toCharArray();
        long[] dp = new long[n];
        dp[0] = chars[0]-'0';
        long preSum = chars[0]-'0';
        long prevPrevSum = 0;
        for (int i = 1; i < n; i++) {
            prevPrevSum += i>=2?dp[i-2]:0;
            int si = chars[i]-'0';
            long singleAddition = modPow(2, i - 1, MOD) * si % MOD;
            // 直左に+が挟まる場合、現状全てに対してsiを足す
            // => i-1文字目までの好きなところに + が入ることを考えて...
            dp[i] = (dp[i-1]+singleAddition)%MOD;
            // 直左に+が挟まらない場合、末尾の数字に10倍してsiを足すことを考える（事前に持っておく）
            // 末尾でない数字の部分（+が挟まるところも込みで数字を持てれば...）
            preSum = (preSum*10%MOD + singleAddition) % MOD;
            dp[i] += preSum+prevPrevSum;
            dp[i] %= MOD;
            preSum = (preSum+singleAddition)%MOD;

        }
        out.println(dp[n-1]);
        out.flush();
    }

    private static long modCombination(long n, long k, int mod) {
        if (n<k) return 0;
        long numerator = modFact(n, n-k, mod);
        long denominator = modFact(k, 0, mod);
        long invDenominator = modPow(denominator, mod - 2, mod);

        return numerator * invDenominator % mod;
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