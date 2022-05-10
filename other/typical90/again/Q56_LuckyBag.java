package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q56_LuckyBag {

    public static void main(String[] args) {
        int n = nextInt();
        int s = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = nextInt();
        }

        boolean[][] dp = new boolean[n+1][s+1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < s; j++) {
                int ai = a[i-1];
                if (j+ ai <= s) {
                    dp[i][j+ ai] |= dp[i-1][j];
                }
                int bi = b[i-1];
                if (j+ bi <= s) {
                    dp[i][j+ bi] |= dp[i-1][j];
                }
            }
        }

        if (!dp[n][s]) {
            System.out.println("Impossible");
            return;
        }

        int index = s;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (index-a[i]>=0&&dp[i][index-a[i]]) {
                sb.append("A");
                index-=a[i];
                continue;
            }
            sb.append("B");
            index-=b[i];
        }
        out.println(sb.reverse().toString());
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