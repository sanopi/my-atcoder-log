import java.io.PrintWriter;
import java.util.Scanner;

public class ABC312D {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        long[][] dp = new long[n][n+1];
        if (s.charAt(0) == '(' || s.charAt(0) == '?') {
            dp[0][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            char si = s.charAt(i);
            if (si == '(') {
                for (int j = 1; j < n; j++) {
                    dp[i][j] += dp[i-1][j-1];
                    dp[i][j] %= MOD;
                }
            } else if (si == ')') {
                for (int j = 0; j < n-1; j++) {
                    dp[i][j] += dp[i-1][j+1];
                    dp[i][j] %= MOD;
                }
            } else {
                for (int j = 1; j < n; j++) {
                    dp[i][j] += dp[i-1][j-1];
                    dp[i][j] %= MOD;
                }
                for (int j = 0; j < n-1; j++) {
                    dp[i][j] += dp[i-1][j+1];
                    dp[i][j] %= MOD;
                }
            }
        }
        out.println(dp[n-1][0]);

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