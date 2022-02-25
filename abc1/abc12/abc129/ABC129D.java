import java.io.PrintWriter;
import java.util.Scanner;

public class ABC129D {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = next().toCharArray();
        }

        int[][] wCounts = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                wCounts[i][j] = s[i][j]=='.' ? (j>0?wCounts[i][j-1]:0)+1 : 0;
            }
            for (int j = w-2; j >= 0; j--) {
                wCounts[i][j] = Math.max(
                    wCounts[i][j],
                    s[i][j]=='.' ? wCounts[i][j+1] : 0
                );
            }
        }

        int[][] hCounts = new int[h][w];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                hCounts[j][i] = s[j][i]=='.' ? (j>0?hCounts[j-1][i]:0)+1 : 0;
            }
            for (int j = h - 2; j >= 0; j--) {
                hCounts[j][i] = Math.max(
                    hCounts[j][i],
                    s[j][i]=='.' ? hCounts[j+1][i] : 0
                );
            }
        }
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans = Math.max(ans, hCounts[i][j]+wCounts[i][j]-1);
            }
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