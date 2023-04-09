import java.io.PrintWriter;
import java.util.Scanner;

public class ABC297F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int k = nextInt();

        // iCk を事前計算
        long[] fact = new long[h*w+1];
        fact[k] = 1;
        for (int i = k+1; i < h * w + 1; i++) {
            fact[i] = fact[i-1] * modPow(i - k, MOD - 2, MOD) % MOD * i % MOD;
        }

        long ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                long result = 0;
                int l = j;
                int r = w - l - 1;
                int u = i;
                int d = h - u - 1;
                // 右側
                result = (result + fact[r * h]) %MOD;
                // 下側
                result = (result + fact[w * d]) %MOD;

                // 左側
                result = (result + fact[l * h]) %MOD;

                // 上側
                result = (result + fact[w * u]) %MOD;

                // 右上
                result = (result - fact[r * u]) %MOD;

                // 右下
                result = (result - fact[r * d]) %MOD;

                // 左下
                result = (result - fact[l * d]) %MOD;

                // 左上
                result = (result - fact[l * u]) %MOD;

                ans += (fact[h*w] - result);
                ans = (ans+MOD)%MOD;
            }
        }
        long base = modPow(fact[h*w], MOD-2, MOD);
        out.println(ans*base%MOD);
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