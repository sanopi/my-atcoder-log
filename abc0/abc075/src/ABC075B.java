import java.io.PrintWriter;
import java.util.Scanner;

public class ABC075B {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (g[i][j] == '.') {
                    int count = 0;
                    for (int k = -1; k <= 1; k++) {
                        for (int l = -1; l <= 1; l++) {
                            int x = i+k;
                            int y = j+l;
                            if (x < 0 || x >= h || y < 0 || y >= w) continue;
                            if (g[x][y] == '#') {
                                count++;
                            }
                        }
                    }
                    g[i][j] = (char)(count + '0');
                }
            }
        }
        for (final char[] chars : g) {
            out.println(String.valueOf(chars));
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