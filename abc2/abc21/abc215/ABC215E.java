import java.io.PrintWriter;
import java.util.Scanner;

public class ABC215E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

        // n文字目まで、最後の文字がi、jが使用されている
        long[][][] dp = new long[n][10][1<<10];
        int p = s.charAt(0) - 'A';
        dp[0][p][1<<p] = 1;
        for (int i = 1; i < n; i++) {
            p = s.charAt(i) - 'A';
            // k==0 : 何も選択していない時
            dp[i][p][1<<p] += 1;
            for (int j = 0; j < 10; j++) {
                for (int k = 1; k < 1 << 10; k++) {
                    // i文字目を選択しない
                    dp[i][j][k] += dp[i-1][j][k];
                    dp[i][j][k] %= MOD;

                    // i文字目を選択するが、最後の文字と同じ
                    if (j == p) {
                        dp[i][j][k] += dp[i-1][j][k];
                        dp[i][j][k] %= MOD;
                    }
                    // i文字目を選択して、最後の文字と異なる
                    if ((k & (1<<p)) == 0) {
                        dp[i][p][k|(1<<p)] += dp[i-1][j][k];
                        dp[i][p][k|(1<<p)] %= MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 1 << 10; j++) {
                ans += dp[n-1][i][j];
                ans %= MOD;
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