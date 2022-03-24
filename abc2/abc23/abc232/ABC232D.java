import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC232D {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }

        int[][] cost = new int[h][w];
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(0, 0, 1));
        while (!q.isEmpty()) {
            P c = q.poll();
            if (cost[c.i][c.j] < c.count) {
                cost[c.i][c.j] = c.count;
                for (P p : c.next()) {
                    if (p.isValid(h, w) && g[p.i][p.j] == '.') {
                        q.add(p);
                    }
                }
            }
        }

        out.println(Arrays.stream(cost).mapToInt(ints -> Arrays.stream(ints).max().getAsInt()).max().getAsInt());
        out.flush();
    }

    private static class P {
        int i;
        int j;
        int count;
        public P(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }
        private List<P> next() {
            return List.of(new P(i+1, j, count+1), new P(i, j+1, count+1));
        }
        private boolean isValid(int h, int w) {
            return i<h && j<w;
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