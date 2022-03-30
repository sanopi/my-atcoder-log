import java.io.PrintWriter;
import java.util.Scanner;

public class ABC240C {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
            b[i] = nextInt();
        }


        boolean[][] dp = new boolean[n+1][10001];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10001; j++) {
                int ja = j + a[i];
                if (ja < 10001) {
                    dp[i+1][ja] |= dp[i][j];
                }
                int jb = j + b[i];
                if (jb < 10001) {
                    dp[i+1][jb] |= dp[i][j];
                }
            }
        }
        out.println(dp[n][x]?"Yes":"No");
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