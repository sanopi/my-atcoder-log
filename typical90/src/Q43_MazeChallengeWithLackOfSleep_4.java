import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
    static int[][][] costs;

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
        costs = new int[h][w][4];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        Arrays.fill(costs[s.x][s.y], 0);
        Deque<Entity> deque = new ArrayDeque<>();
        for (int i = 0; i < 4; i++) {
            deque.offerLast(new Entity(s, i));
        }
        while (deque.peek() != null) {
            Entity entity = deque.pollFirst();
            Pair point = entity.point;
            int dir = entity.dir;
            for (int i = 0; i < 4; i++) {
                Pair next = new Pair(point.x + dirs[i].x, point.y + dirs[i].y);
                int nextCost = costs[point.x][point.y][dir] + (dir == i ? 0 : 1);
                if (valid(next) && g[next.x][next.y] == '.' && costs[next.x][next.y][i] > nextCost) {
                    costs[next.x][next.y][i] = nextCost;
                    if (dir == i) {
                        deque.offerFirst(new Entity(next, i));
                    } else {
                        deque.offerLast(new Entity(next, i));
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            ans = Math.min(ans, costs[rt][ct][i]);
        }

        out.println(ans);
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

    private static class Entity {
        Pair point;
        int dir;
        Entity(Pair point, int dir) {
            this.point = point;
            this.dir = dir;
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