import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ABC213E {

    static int h;
    static int w;

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }

        Deque<Pair> deque = new ArrayDeque<>();
        int[][] costs = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        costs[0][0] = 0;

        int[] nx = {1, 0, -1, 0};
        int[] ny = {0, 1, 0, -1};
        deque.add(new Pair(0, 0));
        while (deque.peek() != null) {
            Pair now = deque.poll();
            int cost = costs[now.x][now.y];
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(now.x + nx[i], now.y + ny[i]);
                if (!next.valid()) continue;
                if (g[next.x][next.y] == '#') continue;
                if (costs[next.x][next.y] <= cost) continue;
                costs[next.x][next.y] = cost;
                deque.addFirst(next);
            }
            for (int i = -2; i <= 2; i++) {
                for (int  j = -2;  j <= 2;  j++) {
                    if (Math.abs(i) + Math.abs(j) > 3) continue;
                    Pair next = new Pair(now.x + i, now.y + j);
                    if (!next.valid()) continue;
                    if (costs[next.x][next.y] <= cost+1) continue;
                    costs[next.x][next.y] = cost+1;
                    deque.addLast(next);
                }
            }
        }
        out.println(costs[h-1][w-1]);
        out.flush();
    }

    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }

        boolean valid() {
            return x >= 0 && x < h && y >= 0 && y < w;
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}