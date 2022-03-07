import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AGC033A {
    private static char[][] g;
    private static int[][] diff;
    private static int h;
    private static int w;

    private static final int[] nx = {1, 0, -1, 0};
    private static final int[] ny = {0, -1, 0, 1};

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }

        int ans;
//        ans = solve1();
        ans = solve2();


        out.println(ans);
        out.flush();
    }

    private static int solve2() {
        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (g[i][j] == '#') {
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int ans = 0;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = current.x+nx[i];
                int y = current.y+ny[i];
                if (0 <= x && x < h && 0 <= y && y < w) {
                    if (g[x][y] == '#') continue;
                    g[x][y] = '#';
                    ans = Math.max(ans, current.count+1);
                    q.add(new Pair(x, y, current.count+1));
                }
            }
        }
        return ans;
    }

    private static class Pair {
        int x;
        int y;
        int count;
        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static int solve1() {
        diff = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                diff[i][j] = g[i][j]=='#'?0:1000000;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                diff[i][j] = Math.min(
                    diff[i][j],
                    diff[i][j - 1] + 1
                );
            }
            for (int j = w - 2; j >= 0; j--) {
                diff[i][j] = Math.min(
                    diff[i][j],
                    diff[i][j + 1] + 1
                );
            }
        }
        for (int i = 0; i < w; i++) {
            for (int j = 1; j < h; j++) {
                diff[j][i] = Math.min(
                    diff[j][i],
                    diff[j - 1][i] + 1
                );
            }
            for (int j = h - 2; j >= 0; j--) {
                diff[j][i] = Math.min(
                    diff[j][i],
                    diff[j + 1][i] + 1
                );
            }
        }
        return Arrays.stream(diff)
            .flatMapToInt(ints -> Arrays.stream(ints))
            .max().getAsInt();
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