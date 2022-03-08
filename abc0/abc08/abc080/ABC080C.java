import java.io.PrintWriter;
import java.util.Scanner;

public class ABC080C {

    public static void main(String[] args) {
        int n = nextInt();
        int[][] f = new int[n][10];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = nextInt();
            }
        }
        int[][] p = new int[n][11];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                p[i][j] = nextInt();
            }
        }

        long ans = Long.MIN_VALUE;
        for (int i = 1; i < 1 << 10; i++) {
            boolean[] open = new boolean[10];
            for (int j = 0; j < 10; j++) {
                if ((i&(1<<j)) != 0) {
                    open[j] = true;
                }
            }
            long rieki = 0;
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 10; k++) {
                    if (f[j][k] == 1 && open[k]) {
                        count++;
                    }
                }
                rieki += p[j][count];
            }
            ans = Math.max(ans, rieki);
        }
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