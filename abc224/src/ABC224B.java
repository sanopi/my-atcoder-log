import java.io.PrintWriter;
import java.util.Scanner;

public class ABC224B {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = nextInt();
            }
        }

        boolean ok = true;
        o:
        for (int i = 0; i < h-1; i++) {
            for (int j = 0; j < w-1; j++) {
                for (int k = i; k < h; k++) {
                    for (int l = j; l < w; l++) {
                        if (a[i][j] + a[k][l] > a[i][l] + a[k][j]) {
                            ok = false;
                            break o;
                        }
                    }
                }
            }
        }
        out.println(ok ? "Yes" : "No");

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