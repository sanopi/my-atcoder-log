import java.io.PrintWriter;
import java.util.Scanner;

public class ABC249E {

    public static void main(String[] args) {
        int n = nextInt();
        int p = nextInt();
        int nLen = String.valueOf(n).length();

        long[][] dp = new long[n+1][2*n+1];
        long[][] sum = new long[n+2][3*n];
        dp[0][0] = 1;
        sum[1][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 2*i; j++) {
                for (int k = 2; k <= Math.min(nLen+1, j); k++) {
                    int min = Integer.parseInt("1" + "0".repeat(k - 2));
                    if (i < min) {
                        continue;
                    }
                    int max = Math.min(i, min*10-1);
                    dp[i][j] += (sum[i-min+1][j-k] - sum[i-max][j-k])*(j-k==0?26:25);
                    dp[i][j] %= p;
                }
                sum[i+1][j] += dp[i][j] + sum[i][j];
                sum[i+1][j] %= p;
//                System.out.println(i+" " + j + " " + dp[i][j] + " " + sum[i+1][j]);
            }
        }

        long ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += dp[n][i];
            ans %= p;
        }
        ans+=p;
        out.println(ans%p);
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