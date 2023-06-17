import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ABC306D {

    public static void main(String[] args) {
        int n = nextInt();
        long[][] dp = new long[n+1][2];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            // 食べない
            dp[i+1][0] = Math.max(dp[i+1][0], dp[i][0]);
            dp[i+1][1] = Math.max(dp[i+1][1], dp[i][1]);

            // 食べる
            if (x == 0) {
                dp[i+1][0] = LongStream.of(dp[i+1][0], dp[i][0]+y, dp[i][1]+y).max().getAsLong();
            }
            if (x == 1) {
                dp[i+1][1] = LongStream.of(dp[i+1][1], dp[i][0]+y).max().getAsLong();
            }
        }
        out.println(Math.max(dp[n][0], dp[n][1]));
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