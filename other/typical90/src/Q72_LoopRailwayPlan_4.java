import java.io.PrintWriter;
import java.util.Scanner;

public class Q72_LoopRailwayPlan_4 {

    static int h;
    static int w;
    static char[][] g;
    static int[] nx = {1, 0, -1, 0};
    static int[] ny = {0, 1, 0, -1};
    static int max = 0;

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();

        g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (g[i][j] == '#') continue;
                dfs(i, j, i, j, 0);
            }
        }
        int ans = max >= 3 ? max : -1;
        out.println(ans);
        out.flush();
    }

    static void dfs(int x, int y, int ex, int ey, int dep) {
        if (x == ex && y == ey && dep != 0) {
            max = Math.max(max, dep);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nex = x + nx[i], ney = y + ny[i];
            if (!valid(nex, ney)) continue;
            if (g[nex][ney] == '#') continue;
            g[nex][ney] = '#';
            dfs(nex, ney, ex, ey, dep+1);
            g[nex][ney] = '.';
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < h && y >= 0 && y < w;
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}