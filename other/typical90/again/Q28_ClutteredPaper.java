package again;

import java.io.PrintWriter;
import java.util.Scanner;

public class Q28_ClutteredPaper {

    public static void main(String[] args) {
        int[][] grid = new int[1001][1001];
        int n = nextInt();
        for (int i = 0; i < n; i++) {
            int lx = nextInt();
            int ly = nextInt();
            int rx = nextInt();
            int ry = nextInt();

            grid[lx][ly]++;
            grid[lx][ry]--;
            grid[rx][ly]--;
            grid[rx][ry]++;
        }
        for (int i = 0; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                grid[i][j] += grid[i][j-1];
            }
        }
        for (int i = 0; i < 1001; i++) {
            for (int j = 1; j < 1001; j++) {
                grid[j][i] += grid[j-1][i];
            }
        }
        int[] count = new int[n+1];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                count[grid[i][j]]++;
            }
        }
        for (int i = 1; i <= n; i++) {
            out.println(count[i]);
        }
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