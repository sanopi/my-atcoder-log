import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC069D {

    private static int[][] ans;
    private static int[] a;
    private static int h;
    private static int w;
    private static int n;
    private static final int[] nextX = {1, 0, -1, 0};
    private static final int[] nextY = {0, 1, 0, -1};

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        n = nextInt();
        a = nextIntArray(n);

        ans = new int[h][w];
        dfs(new Pair(0, 0), 0);

        for (int[] aa : ans) {
            for (int i : aa) {
                out.print(i + " ");
            }
            out.println();
        }
        out.flush();
    }

    private static void dfs(Pair current, int color) {
        while (a[color]==0){
            color++;
        }
        ans[current.x][current.y] = color+1;
        a[color]--;
        for (Pair next : current.nexts()) {
            if (next.isValid() && !next.isDone()) {
                dfs(next, color);
            }
        }
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private List<Pair> nexts() {
            List<Pair> res = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(x + nextX[i], y + nextY[i]);
                res.add(next);
            }
            return res;
        }
        private boolean isValid() {
            return x >=0 && x < h && y >= 0 && y < w;
        }
        private boolean isDone() {
            return ans[x][y]>0;
        }
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