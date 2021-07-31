import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Q43_MazeChallengeWithLackOfSleep_4 {

    static int h;
    static int w;
    static int rs;
    static int cs;
    static int rt;
    static int ct;
    static char[][] g;
    static int[][] costs;

    static Pair[] dirs = {new Pair(1, 0), new Pair(0, 1), new Pair(-1, 0), new Pair(0, -1)};

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        rs = nextInt()-1;
        cs = nextInt()-1;
        rt = nextInt()-1;
        ct = nextInt()-1;
        Pair s = new Pair(rs, cs);
        g = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] wall = next().toCharArray();
            g[i] = wall;
        }
        costs = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(costs[i], -2);
        }
        costs[s.x][s.y] = -1;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(s);
        while (queue.peek() != null) {
            Pair point = queue.poll();
            g[point.x][point.y] = '#';
            int nextCost = costs[point.x][point.y] + 1;
            for (Pair dir : dirs) {
                Pair next = new Pair(point.x + dir.x, point.y + dir.y);
                while (valid(next) && g[next.x][next.y] == '.') {
                    if (costs[next.x][next.y] == -2) {
                        costs[next.x][next.y] = nextCost;
                        queue.add(next);
                        if (next.x == rt && next.y == ct) {
                            queue.clear();
                            break;
                        }
                    }
                    next = new Pair(next.x + dir.x, next.y + dir.y);
                }
            }
        }

        out.println(costs[rt][ct]);
        out.flush();
    }


    private static boolean valid(Pair xy) {
        int x = xy.x;
        int y = xy.y;
        return (x >= 0) && (x < h) && (y >= 0) && (y < w);
    }

    private static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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