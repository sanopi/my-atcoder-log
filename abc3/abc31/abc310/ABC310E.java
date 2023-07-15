import java.io.PrintWriter;
import java.util.Scanner;

public class ABC310E {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

        int[][] dp = new int[n][2];
        dp[0][s.charAt(0)-'0']++;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i)-'0' == 0) {
                dp[i][1] = dp[i-1][0] + dp[i-1][1];
            } else {
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0];
            }
            dp[i][s.charAt(i)-'0']++;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i][1];
        }
        out.println(ans);

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