import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC109D {

    private static final String FORMAT = "%d %d %d %d";

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] g = new int[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = nextIntArray(w);
        }
        int count = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            if (i%2==0) {
                for (int j = 0; j < w-1; j++) {
                    if (g[i][j]%2==1) {
                        g[i][j]--;
                        g[i][j+1]++;

                        ans.add(String.format(FORMAT, i+1, j+1, i+1, j+2));
                        count++;
                    }
                }
                if (g[i][w-1]%2==1 && i<h-1) {
                    g[i][w-1]--;
                    g[i+1][w-1]++;
                    ans.add(String.format(FORMAT, i+1, w, i+2, w));
                    count++;
                }

            } else {
                for (int j = w - 1; j > 0; j--) {
                    if (g[i][j]%2==1) {
                        g[i][j]--;
                        g[i][j-1]++;
                        ans.add(String.format(FORMAT, i+1, j+1, i+1, j));
                        count++;
                    }
                }
                if (g[i][0]%2==1 && i<h-1) {
                    g[i][0]--;
                    g[i+1][0]++;
                    ans.add(String.format(FORMAT, i+1, 1, i+2, 1));
                    count++;
                }
            }
        }
        System.out.println(count);
        ans.forEach(out::println);
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