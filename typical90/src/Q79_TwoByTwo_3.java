import java.io.PrintWriter;
import java.util.Scanner;

public class Q79_TwoByTwo_3 {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] diffs = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                diffs[i][j] = nextInt();
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                diffs[i][j] -= nextInt();
            }
        }

        long sum = 0;
        for (int i = 0; i < h-1; i++) {
            for (int j = 0; j < w-1; j++) {
                int point = diffs[i][j];
                diffs[i+1][j] -= point;
                diffs[i][j+1] -= point;
                diffs[i+1][j+1] -= point;
                sum += Math.abs(point);
            }
            if (diffs[i][w-1] != 0) {
                System.out.println("No");
                return;
            }
        }
        out.println("Yes");
        out.println(sum);
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}