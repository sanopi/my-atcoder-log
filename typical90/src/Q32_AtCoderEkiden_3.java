import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q32_AtCoderEkiden_3 {

    static int n;
    static int[][] a;
    static boolean[][] g;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        n = nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }
        int m = nextInt();
        g = new boolean[n][n];
        for (int i = 0; i < n; i++) { Arrays.fill(g[i], true); }
        for (int i = 0; i < m; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            g[x][y] = false;
            g[y][x] = false;
        }


        int[] runner = new int[n];
        Arrays.fill(runner, -1);
        fillMin(runner, 0);
        out.print(min == Integer.MAX_VALUE ? -1 : min);
        out.flush();
    }

    private static void fillMin(int[] runners, int index) {
        if (index == n) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += a[runners[i]][i];
            }
            if (res < min) {
                min = res;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean contains = false;
            for (int runner : runners) {
                if (i == runner) {
                    contains = true;
                    break;
                }
            }

            boolean ok = index == 0 || g[runners[index-1]][i];
            if (!contains && ok) {
                runners[index] = i;
                fillMin(runners, index+1);
                runners[index] = -1;
            }
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
}