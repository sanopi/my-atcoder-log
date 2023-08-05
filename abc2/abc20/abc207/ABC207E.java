import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC207E {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + a[i];
        }

        // aiまで見た時のjで割り切れるindex
        int[][] prev = new int[n][n+1];
        // iで割って余りがjのときのIndex
        int[][] rest = new int[n+1][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(prev[i], -1);
        }
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(rest[i], -1);
        }

        for (int i = 0; i < n; i++) {
            long si = sum[i+1];
            for (int j = 1; j <= n; j++) {
                int amari = (int) (si % j);
                prev[i][j] = rest[j][amari];
                rest[j][amari] = i;
            }
        }

        long[][] dp = new long[n][n+1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j <= n; j++) {
                int pre = prev[i][j];
                if (pre == -1) continue;
                dp[i][j] = (dp[pre][j]+dp[pre][j-1])%MOD;
            }
        }
        long ans = 0;
        for (long l : dp[n - 1]) {
            ans = (ans+l)%MOD;
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