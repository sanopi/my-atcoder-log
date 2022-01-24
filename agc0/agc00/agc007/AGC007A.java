import java.io.PrintWriter;
import java.util.Scanner;

public class AGC007A {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (g[i][j]=='#') {
                    if (i>0||j>0) {
                        if ((i>0&&g[i-1][j] != '#') && (j>0&&g[i][j-1] != '#')) {
                            System.out.println("Impossible");
                            return;
                        }
                    }
                    if (i<h-1||j<w-1) {
                        if (((i<h-1&&g[i+1][j]=='#') && (j<w-1&&g[i][j+1]=='#'))
                        || ((i<h-1&&g[i+1][j]!='#') && (j<w-1&&g[i][j+1]!='#'))) {
                            System.out.println("Impossible");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Possible");
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