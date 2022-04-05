import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class N_Slimes {

    private static long[][] dp;
    private static long[] sum;

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);

        long ans;
//        ans = solve1_wa(a);
        ans = solve2(n, a);
        out.println(ans);
        out.flush();
    }

    private static long solve2(int n, long[] a) {
        dp = new long[n][n+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + a[i];
        }

        return memoRec(0, n);
    }

    private static long memoRec(int l, int r) {
        if (dp[l][r]<Long.MAX_VALUE) return dp[l][r];
        if (l==r-1) return dp[l][r] = 0;
        long res = Long.MAX_VALUE;
        for (int i = l+1; i < r; i++) {
            long left = memoRec(l, i) + (sum[i] - sum[l]);
            long right = memoRec(i, r) + (sum[r] - sum[i]);
            res = Math.min(res, left+right);
        }
        return dp[l][r] = res;
    }

    /**
     * 例えば下記の時WAとなる
     * [4, 5, 3, 5]
     * この解き方では37
     * 4 5 3 5 | 0
     * 4 8 5 | 8
     * 12 5 | 20
     * 17 | 37
     * 正しい答えは34
     * 4 5 3 5 | 0
     * 9 3 5 | 9
     * 9 8 | 17
     * 17 | 34
     */
    private static long solve1_wa(long[] a) {
        long ans;
        ans = 0;
        while (a.length>1) {
            int i = 0;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[i]+ a[i+1] > a[j]+ a[j+1]) {
                    i=j;
                }
            }
            ans += a[i] + a[i+1];
            long[] newA = new long[a.length-1];
            for (int j = 0; j < a.length-1; j++) {
                if (i==j) {
                    newA[j] = a[j]+ a[j+1];
                } else if (i<j) {
                    newA[j] = a[j+1];
                } else {
                    newA[j] = a[j];
                }
            }
            a = newA;
        }
        return ans;
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