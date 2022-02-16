import java.io.PrintWriter;
import java.util.Scanner;

public class DDCC2020QualC {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int k = nextInt();
        int[][] ans = new int[h][w];
        int num = 1;
        for (int i = 0; i < h; i++) {
            char[] chars = next().toCharArray();
            for (int j = 0; j < w; j++) {
                if (chars[j]=='#') {
                    ans[i][j] = num++;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (ans[i][j] ==0) {
                    ans[i][j] = ans[i][j-1];
                }
            }
            for (int j = w - 2; j >= 0; j--) {
                if (ans[i][j] ==0) {
                    ans[i][j] = ans[i][j+1];
                }
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 1; j < h; j++) {
                if (ans[j][i] ==0) {
                    ans[j][i] = ans[j-1][i];
                }
            }
            for (int j = h - 1; j >= 0; j--) {
                if (ans[j][i] ==0) {
                    ans[j][i] = ans[j+1][i];
                }
            }
        }
        for (int[] row : ans) {
            for (int e : row) {
                out.print(e + " ");
            }
            out.println();
        }
        out.println();

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