import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ABC308D {

    private static final Map<Character, Character> NEXT = Map.of(
        's','n',
        'n','u',
        'u','k',
        'k','e',
        'e','s'
    );

    private static final int[] X = {1, 0, -1, 0};
    private static final int[] Y = {0, -1, 0, 1};

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] maze = new char[h][w];
        for (int i = 0; i < h; i++) {
            maze[i] = next().toCharArray();
        }
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(0, 0));
        boolean[][] done = new boolean[h][w];
        done[0][0] = true;
        while (!q.isEmpty()) {
            P current = q.poll();
            int cx = current.x;
            int cy = current.y;
            for (int i = 0; i < 4; i++) {
                int nx = cx+X[i];
                int ny = cy+Y[i];
                if (!(0<=nx && nx<h && 0<=ny && ny<w)) continue;
                if (!NEXT.getOrDefault(maze[cx][cy], 'X').equals(maze[nx][ny])) continue;
                if (done[nx][ny]) continue;
                done[nx][ny] = true;
                q.add(new P(nx, ny));
            }
        }

        if (done[h-1][w-1]) {
            out.println("Yes");
        } else {
            out.println("No");
        }
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