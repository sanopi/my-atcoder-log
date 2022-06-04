import java.io.PrintWriter;
import java.util.Scanner;

public class ABC254B {

    public static void main(String[] args) {
        int n = nextInt();
        int[][] ans = new int[n][n+1];
        for (int i = 0; i < n; i++) {
            ans[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                out.print(ans[i][j] + " ");
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