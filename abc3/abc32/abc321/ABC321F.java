import java.io.PrintWriter;
import java.util.Scanner;

public class ABC321F {

    private static final int MOD = 998244353;

    private static void solve() {
        int q = nextInt();
        int k = nextInt();
        long[] dp = new long[k+1];
        dp[0] = 1;
        while (q-->0) {
            char t = next().toCharArray()[0];
            int x = nextInt();
            long[] tmp = new long[k+1];
            for (int i = 0; i < k + 1; i++) {
                tmp[i] = dp[i];
            }
            if (t == '+') {
                for (int i = 0; i < k && i+x <= k; i++) {
                    dp[i+x] += tmp[i];
                    dp[i+x] %= MOD;
                }
            } else {
                for (int i = 0; i < k && i+x <= k; i++) {
                    dp[i+x] -= dp[i];
                    dp[i+x] = (dp[i+x]+MOD)%MOD;
                }
            }
            out.println(dp[k]);
        }
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