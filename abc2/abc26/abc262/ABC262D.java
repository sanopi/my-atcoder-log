import java.io.PrintWriter;
import java.util.Scanner;

public class ABC262D {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        long ans = 0;
        // i個選ぶ
        for (int i = 1; i <= n; i++) {
            // j個目までの数で、k個選んでいる時の、iでの余りがlの時のばあいの数
            long[][][] dp = new long[n+1][i+1][i];
            dp[0][0][0] = 1;
            for (int j = 1; j < n+1; j++) {
                int aj = a[j-1]%i;
                for (int k = 0; k <= i; k++) {
                    for (int l = 0; l < i; l++) {
                        if (dp[j-1][k][l]==0) {
                            continue;
                        }
                        // 選ぶ
                        if (k < i) {
                            dp[j][k+1][(l+aj)%i] += dp[j-1][k][l];
                            dp[j][k+1][(l+aj)%i] %= MOD;
                        }
                        // 選ばない
                        dp[j][k][l] += dp[j-1][k][l];
                        dp[j][k][l] %= MOD;
                    }
                }
            }
            ans += dp[n][i][0];
            ans %= MOD;

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