import java.io.PrintWriter;
import java.util.Scanner;

public class ABC291D {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int ai = nextInt();
            int bi = nextInt();
            a[i] = ai;
            b[i] = bi;
        }
        long[][] dp = new long[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            int ai = a[i];
            int bi = b[i];
            int aii = a[i-1];
            int bii = b[i-1];

            if (ai != aii) {
                dp[i][0] += dp[i-1][0];
            }
            if (ai != bii) {
                dp[i][0] += dp[i-1][1];
            }
            if (bi != aii) {
                dp[i][1] += dp[i-1][0];
            }
            if (bi != bii) {
                dp[i][1] += dp[i-1][1];
            }
            dp[i][0] %= MOD;
            dp[i][1] %= MOD;
        }
        out.println((dp[n-1][0]+dp[n-1][1])%MOD);
        out.flush();
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