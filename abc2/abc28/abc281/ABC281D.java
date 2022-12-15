import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC281D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int d = nextInt();
        int[] a = nextIntArray(n);

        // iまで見た時に、l個足されている数で、あまりがjの数の最大値
        long[][][] dp = new long[n][k+1][d];
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k + 1; l++) {
                Arrays.fill(dp[i][l],-1);
            }
        }
        dp[0][1][a[0]%d] = a[0];
        dp[0][0][0] = 0;
        for (int i = 1; i < n; i++) {
            int ai = a[i];
            for (int l = 0; l <= k; l++) {
                for (int j = 0; j < d; j++) {
                    if (dp[i-1][l][j] == -1) {
                        continue;
                    }
                    // 選ばない場合
                    dp[i][l][j] = Math.max(dp[i][l][j], dp[i-1][l][j]);
                    // 選ぶ場合
                    if (l == k) continue;
                    int nj = (j+ai)%d;
                    dp[i][l+1][nj] = Math.max(dp[i][l+1][nj], dp[i-1][l][j]+ai);
                }

            }
        }
//        for (long[][] longs : dp) {
//            for (long[] aLong : longs) {
//                System.out.println((Arrays.toString(aLong)));
//            }
//            System.out.println();
//        }
        out.println(dp[n-1][k][0]);
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