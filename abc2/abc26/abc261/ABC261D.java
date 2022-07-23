import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC261D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] x = nextIntArray(n);
        int[] bonus = new int[n+1];
        for (int i = 0; i < m; i++) {
            int c = nextInt();
            int y = nextInt();
            bonus[c] = y;
        }
        long[][] ans = new long[n][n+1];
        ans[0][1] = x[0] + bonus[1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 表
                if (j == 0 || ans[i-1][j] > 0) {
                    ans[i][j+1] = Math.max(ans[i][j+1], ans[i-1][j] + x[i] + bonus[j+1]);
                }
                // 裏
                ans[i][0] = Math.max(ans[i][0], ans[i-1][j]);
            }
        }
        out.println(Arrays.stream(ans[n - 1]).max().getAsLong());
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