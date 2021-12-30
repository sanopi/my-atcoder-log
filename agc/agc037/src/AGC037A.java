import java.io.PrintWriter;
import java.util.Scanner;

public class AGC037A {

    public static void main(String[] args) {
        String s = next();
//        solve1(s);
        solve2(s);
        out.flush();
    }
    private static void solve2(final String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[n][2];
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(chars[i] != chars[i - 1] ?dp[i-1][0]+1:0, dp[i-1][1]+1);
            dp[i][1] = Math.max((i>1?dp[i-2][0]+1:0), (i>3&&!(chars[i]==chars[i-2]&&chars[i-1]==chars[i-3])?dp[i-2][1]+1:0));
        }
        out.println(Math.max(dp[n-1][0], dp[n-1][1]));
    }
    private static void solve1(final String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int count = 1;
        String prev = String.valueOf(chars[0]);
        int i = 1;
        for (; i < n-1; i++) {
            if (String.valueOf(chars[i]).equals(prev)) {
                prev = String.valueOf(chars[i]) + String.valueOf(chars[++i]);
            } else {
                prev = String.valueOf(chars[i]);
            }
            count++;
        }
        if (i != n && !prev.equals(String.valueOf(chars[n - 1]))) {
            count++;
        }
        out.println(count);
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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