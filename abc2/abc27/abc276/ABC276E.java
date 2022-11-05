import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public class ABC276E {

    private static int h;
    private static int w;
    private static Pair start;
    private static boolean[] grid;
    private static boolean[] done;
    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        grid = new boolean[h*w];
        start = null;
        for (int i = 0; i < h; i++) {
            char[] chars = next().toCharArray();
            for (int j = 0; j < w; j++) {
                Pair current = new Pair(i, j);
                if (chars[j] == 'S') {
                    start = current;
                    grid[current.toNum()] = false;
                } else if (chars[j] == '.') {
                    grid[current.toNum()] = true;
                } else {
                    grid[current.toNum()] = false;
                }
            }
        }
        for (Pair first : start.nexts()) {
            if (!grid[first.toNum()]) continue;
            Queue<Pair> q = new ArrayDeque<>();
            q.add(first);

            done = new boolean[h*w];
            done[first.toNum()] = true;

            while (!q.isEmpty()) {
                Pair current = q.poll();
                for (Pair next : current.nexts()) {
                    if (next.equals(start)) {
                        if (!current.equals(first)) {
                            System.out.println("Yes");
                            return;
                        }
                        continue;
                    }
                    if (!grid[next.toNum()]) continue;
                    if (done[next.toNum()]) continue;
                    done[next.toNum()] = true;
                    q.add(next);
                }

            }
        }
        out.println("No");
        out.flush();
    }

    private static boolean dfs(Pair current, Pair first) {
        boolean result = false;
        for (Pair next : current.nexts()) {
            if (next.equals(start)) {
                if (!current.equals(first)) {
                    return true;
                }
                continue;
            }
            if (!grid[next.toNum()]) continue;
            if (done[next.toNum()]) continue;
            done[next.toNum()] = true;
            result |= dfs(next, first);
        }
        return result;
    }

    private static class Pair {
        private static int[] X = {1, 0, -1, 0};
        private static int[] Y = {0, -1, 0, 1};
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private int toNum() {
            return this.x*w+this.y;
        }
        private static Pair fromNum(int num) {
            return new Pair(num/w, num%w);
        }
        private List<Pair> nexts() {
            List<Pair> result = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int nx = x+X[i];
                int ny = y+Y[i];
                if (0<=nx && nx<h && 0<=ny && ny<w) {
                    result.add(new Pair(nx, ny));
                }
            }
            return result;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public String toString() {
            return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
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