import java.io.PrintWriter;
import java.util.Scanner;

public class Q6_LCS {

    public static void main(String[] args) {
        char[] s = next().toCharArray();
        char[] t = next().toCharArray();

        int[][] dp = new int[s.length][t.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < t.length; j++) {
                if (s[i] == t[j]) {
                    dp[i][j] = ((i>0&&j>0) ? dp[i-1][j-1] : 0) + 1;
                } else {
                    dp[i][j] = Math.max(i>0?dp[i-1][j]:0, j>0?dp[i][j-1]:0);
                }
            }
        }

        int len = dp[s.length-1][t.length-1];
        StringBuilder ans = new StringBuilder();
        int ti = t.length-1;
        int si = s.length-1;
        while (len > 0) {
            if (s[si] == t[ti]) {
                ans.append(s[si]);
                si--;
                ti--;
                len--;
            } else if ((si>0?dp[si-1][ti]:0) == len) {
                si--;
            } else {
                ti--;
            }
        }

        out.println(ans.reverse());
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