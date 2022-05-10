package again;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Q43_MazeChallengeWithLackOfSleep {

    private static final int[] X = {1, 0, -1, 0};
    private static final int[] Y = {0, -1, 0, 1};

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int rs = nextInt()-1;
        int cs = nextInt()-1;
        int rt = nextInt()-1;
        int ct = nextInt()-1;

        char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = next().toCharArray();
        }

        int[][][] costs = new int[h][w][4];
        for (int i = 0; i < h; i++) for (int j = 0; j < w; j++) Arrays.fill(costs[i][j], Integer.MAX_VALUE);
        Arrays.fill(costs[rs][cs], 0);
        Deque<P> deque = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            deque.add(new P(rs, cs, i));
        }

        while (!deque.isEmpty()) {
            P current = deque.pollFirst();
            int cx = current.x;
            int cy = current.y;
            int cd = current.d;
            int c = costs[cx][cy][cd];
            for (int d = 0; d < 4; d++) {
                int nx = cx + X[d];
                int ny = cy + Y[d];
                if (0>nx || nx>=h || 0>ny || ny>=w || grid[nx][ny]=='#') continue;
                int nc = c + (cd == d ? 0 : 1);
                if (costs[nx][ny][d] <= nc) continue;
                costs[nx][ny][d] = nc;
                if (c == nc) {
                    deque.addFirst(new P(nx, ny, d));
                } else {
                    deque.addLast(new P(nx, ny, d));
                }
            }
        }
        out.println(Arrays.stream(costs[rt][ct]).min().getAsInt());
        out.flush();
    }

    private static class P {
        int x;
        int y;
        int d;
        public P(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
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