import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ABC323F {

    private static final int[] DI = {1, 0, -1, 0};
    private static final int[] DJ = {0, -1, 0, 1};

    private static void solve() {
        long xa = nextLong();
        long ya = nextLong();
        long xb = nextLong();
        long yb = nextLong();
        long xc = nextLong();
        long yc = nextLong();

        int[][] grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = 10;
            }
        }
        int is = 1 + (int) Math.min(1, Math.max(-1, ya - yb));
        int js = 1 + (int) Math.min(1, Math.max(-1, xa - xb));
        grid[is][js] = 0;
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(is, js));
        while (!q.isEmpty()) {
            P current = q.poll();
            int ci = current.i;
            int cj = current.j;
            for (int k = 0; k < 4; k++) {
                int ni = ci + DI[k];
                int nj = cj + DJ[k];
                if (!(0 <= ni && ni < 3 && 0 <= nj && nj < 3)) continue;
                if (ni == 1 && nj == 1) continue;
                if (grid[ni][nj] != 10) continue;

                grid[ni][nj] = grid[ci][cj]+1;
                q.add(new P(ni, nj));
            }
        }

        long currentMove = 0;
        if (xa != xb) {
            currentMove += Math.abs(xb-xa)-1;
        }
        if (ya != yb) {
            currentMove += Math.abs(yb-ya)-1;
        }

        long ans = Long.MAX_VALUE;
        // 先にxを移動させるパターン
        {
            // x座標が同じだったらこのパターンは無視。
            if (xb != xc) {
                long tmp = currentMove;
                int jt = 1 + (int) Math.min(1, Math.max(-1, xb - xc));
                tmp += grid[1][jt];
                tmp += Math.abs(xb - xc);
                if (yb != yc) {
                    tmp += 2;
                    tmp += Math.abs(yb - yc);
                }
                ans = Math.min(ans, tmp);
            }
        }
        // 先にyを移動させるパターン
        {
            // y座標が同じだったらこのパターンは無視。
            if (yb != yc) {
                long tmp = currentMove;
                int it = 1 + (int) Math.min(1, Math.max(-1, yb - yc));
                tmp += grid[it][1];
                tmp += Math.abs(yb - yc);
                if (xb != xc) {
                    tmp += 2;
                    tmp += Math.abs(xb - xc);
                }
                ans = Math.min(ans, tmp);
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class P {
        int i;
        int j;
        public P(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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