import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ABC317E {

    private static Map<Character, P> map = Map.of(
        '>', new P(0, 1),
        'v', new P(1, 0),
        '<', new P(0, -1),
        '^', new P(-1, 0)
    );

    private static Set<Character> stop = Set.of('>', 'v', '<', '^', '#');
    private static Set<Character> kabe = Set.of('>', 'v', '<', '^', '#', '!');

    private static int[] X = {1, 0, -1, 0};
    private static int[] Y = {0, -1, 0, 1};

    private static void solve() {
        int h = nextInt();
        int w = nextInt();
        List<P> persons = new ArrayList<>();
        P start = null;
        P goal = null;
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] chars = next().toCharArray();
            for (int j = 0; j < w; j++) {
                if (map.containsKey(chars[j])) {
                    persons.add(new P(i, j));
                }
                if (chars[j] == 'S') {
                    start = new P(i, j);
                }
                if (chars[j] == 'G') {
                    goal = new P(i, j);
                }
            }
            g[i] = chars;
        }

        for (P person : persons) {
            int x = person.x;
            int y = person.y;
            P d = map.get(g[x][y]);
            x += d.x;
            y += d.y;
            while (0<=x && x<h && 0<=y && y<w && !stop.contains(g[x][y])) {
                g[x][y] = '!';
                x += d.x;
                y += d.y;
            }
        }

        int[][] cost = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        Queue<P> q = new ArrayDeque<>();
        q.add(start);
        cost[start.x][start.y] = 0;
        while (!q.isEmpty()) {
            P current = q.poll();
            int cx = current.x;
            int cy = current.y;
            int cc = cost[cx][cy];
            int nc = cc+1;
            for (int i = 0; i < 4; i++) {
                int nx = cx+X[i];
                int ny = cy+Y[i];
                if (0<=nx && nx<h && 0<=ny && ny<w && !kabe.contains(g[nx][ny])) {
                    if (cost[nx][ny] <= nc) continue;
                    cost[nx][ny] = nc;
                    q.add(new P(nx, ny));
                }
            }
        }
        int ans = cost[goal.x][goal.y];
        out.println(ans==Integer.MAX_VALUE?-1:ans);
        out.flush();
    }

    private static class P {
        int x;
        int y;
        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> System.exit(1));
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