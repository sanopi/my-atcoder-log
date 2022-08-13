import java.io.PrintWriter;
import java.util.Scanner;

public class ABC264C {

    public static void main(String[] args) {
        int h1 = nextInt();
        int w1 = nextInt();
        int[][] a = new int[h1][w1];
        for (int i = 0; i < h1; i++) {
            for (int j = 0; j < w1; j++) {
                a[i][j] = nextInt();
            }
        }
        int h2 = nextInt();
        int w2 = nextInt();
        int[][] b = new int[h2][w2];
        for (int i = 0; i < h2; i++) {
            for (int j = 0; j < w2; j++) {
                b[i][j] = nextInt();
            }
        }

        boolean yes = false;
        for (int i = 0; i < 1 << h1; i++) {
            if (Integer.bitCount(i) != h2) continue;
            for (int j = 0; j < 1 << w1; j++) {
                if (Integer.bitCount(j) != w2) continue;
                int[][] c = new int[h2][w2];
                int ind = 0;
                for (int ii = 0; ii < h1; ii++) {
                    if ((i & (1<<ii)) != 0) {
                        int indj = 0;
                        for (int jj = 0; jj < w1; jj++) {
                            if ((j & (1<<jj)) != 0) {
                                c[ind][indj++] = a[ii][jj];
                            }
                        }
                        ind++;
                    }
                }

                boolean ok = true;
                for (int ii = 0; ii < h2; ii++) {
                    for (int jj = 0; jj < w2; jj++) {
                        ok &= c[ii][jj] == b[ii][jj];
                    }
                }

                yes |= ok;
            }
        }

        out.println(yes ? "Yes" : "No");
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