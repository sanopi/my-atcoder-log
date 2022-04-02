import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ABC246E {

    private static int[] NX = {1, 1, -1, -1};
    private static int[] NY = {1, -1, 1, -1};

    public static void main(String[] args) {
        int n = nextInt();
        int ax = nextInt()-1;
        int ay = nextInt()-1;
        int bx = nextInt()-1;
        int by = nextInt()-1;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = next().toCharArray();
        }
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        cost[ax][ay][0] = 1;
        cost[ax][ay][1] = 1;
        cost[ax][ay][2] = 1;
        cost[ax][ay][3] = 1;

        Deque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(ax, ay, 0));
        dq.add(new Point(ax, ay, 1));
        dq.add(new Point(ax, ay, 2));
        dq.add(new Point(ax, ay, 3));
        while (!dq.isEmpty()) {
            Point current = dq.pollFirst();
            int currentCost = cost[current.x][current.y][current.dir];
            for (int i = 0; i < 4; i++) {
                int nx = current.x + NX[i];
                int ny = current.y + NY[i];
                if (!(0 <= nx && nx < n && 0 <= ny && ny < n)) continue;
                if (board[nx][ny] =='#') continue;
                int nextCost = currentCost + (current.dir == i ? 0 : 1);
                if (cost[nx][ny][i] > nextCost) {
                    cost[nx][ny][i] = nextCost;
                    if (current.dir == i) {
                        dq.addFirst(new Point(nx, ny, i));
                    }  else {
                        dq.addLast(new Point(nx, ny, i));
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i : cost[bx][by]) {
            ans = Math.min(ans, i);
        }
        out.println(ans==Integer.MAX_VALUE?-1:ans);
        out.flush();
    }

    private static class Point {
        int x;
        int y;
        int dir;
        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
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