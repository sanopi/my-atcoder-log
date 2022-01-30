import java.io.PrintWriter;
import java.util.Scanner;

public class ABC237B {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = nextInt();
            }
        }

        int[][] b = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                b[i][j] = a[j][i];
            }
        }

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                out.print(b[i][j]+ " ");
            }
            out.println();
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