import java.io.PrintWriter;
import java.util.Scanner;

public class ABC323E {

    private static final int MOD = 998244353;

    private static void solve() {
        int n = nextInt();
        int x = nextInt();
        int[] t = nextIntArray(n);
        long div = modPow(n, MOD-2, MOD);
        // i秒後にちょうど曲が終わる確率
        long[] dp = new long[x+1];
        dp[0] = 1;
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                int tj = t[j];
                int to = i + tj;
                if (to > x) continue;
                dp[to] += dp[i] *div;
                dp[to] %= MOD;
            }
        }

        long ans = 0;
        for (int i = Math.max(0, x-t[0]+1); i <= x; i++) {
            ans = (ans+dp[i]*div)%MOD;
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