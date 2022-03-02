import java.io.PrintWriter;
import java.util.Scanner;

public class AGC038A {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int a = nextInt();
        int b = nextInt();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i<b && j <a) || (i>=b && j >=a)) {
                    out.print(1);
                }else {
                    out.print(0);
                }
            }
            out.println();
        }
        out.flush();
    }

    private static boolean isOk(int[][] grid, int h, int w, int a, int b) {
        for (int i = 0; i < h; i++) {
            int count = 0;
            for (int j : grid[i]) if (j == 0) count++;
            if (a != Math.min(count, w-count)) return false;
        }
        for (int i = 0; i < w; i++) {
            int count = 0;
            for (int j = 0; j < h; j++) if (grid[j][i] == 0) count++;
            if (b != Math.min(count, h-count)) return false;
        }
        return true;
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