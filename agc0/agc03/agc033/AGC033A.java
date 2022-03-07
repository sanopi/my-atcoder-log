import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AGC033A {
    private static char[][] g;
    private static int[][] diff;
    private static int h;
    private static int w;

    private static final int[] nx = {1, 0, -1, 0};
    private static final int[] ny = {0, -1, 0, 1};

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }
        diff = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                diff[i][j] = g[i][j]=='#'?0:1000000;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                diff[i][j] = Math.min(
                    diff[i][j],
                    diff[i][j - 1] + 1
                );
            }
            for (int j = w - 2; j >= 0; j--) {
                diff[i][j] = Math.min(
                    diff[i][j],
                    diff[i][j + 1] + 1
                );
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 1; j < h; j++) {
                diff[j][i] = Math.min(
                    diff[j][i],
                    diff[j - 1][i] + 1
                );
            }
            for (int j = h - 2; j >= 0; j--) {
                diff[j][i] = Math.min(
                    diff[j][i],
                    diff[j + 1][i] + 1
                );
            }
        }

        int ans = Arrays.stream(diff)
            .flatMapToInt(ints -> Arrays.stream(ints))
            .max().getAsInt();
        out.println(ans);
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