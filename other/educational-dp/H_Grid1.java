import java.io.PrintWriter;
import java.util.Scanner;

public class H_Grid1 {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        boolean[][] grid = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            char[] c = next().toCharArray();
            for (int j = 0; j < c.length; j++) {
                grid[i][j] = c[j] == '.';
            }
        }

        int[][] ans = new int[h][w];
        ans[0][0] = 1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i > 0 && grid[i-1][j]) {
                    ans[i][j] += ans[i-1][j];
                    ans[i][j]%=MOD;
                }
                if (j > 0 && grid[i][j-1]) {
                    ans[i][j] += ans[i][j-1];
                    ans[i][j]%=MOD;
                }
            }
        }
        out.println(ans[h-1][w-1]);
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