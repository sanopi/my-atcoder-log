import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC204D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] t = nextIntArray(n);
        int sum = Arrays.stream(t).sum();

        boolean[][] dp = new boolean[n][sum+1];
        dp[0][0] = true;
        dp[0][t[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (!dp[i - 1][j]) {
                    continue;
                }
                dp[i][j] = true;
                dp[i][j+t[i]] = true;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < sum+1; i++) {
            if (dp[n-1][i] && (i * 2) >= sum) {
                ans = i;
                break;
            }
        }

        out.println(ans);
        out.flush();
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