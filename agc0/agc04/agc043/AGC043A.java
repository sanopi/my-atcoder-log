import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class AGC043A {

    private static int[] nextX = {0, 1};
    private static int[] nextY = {1, 0};

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = next().toCharArray();
        }

        int[][] costs = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
        }
        int firstCost = s[0][0] == '#' ? 1 : 0;
        costs[0][0] = firstCost;

        Deque<P> deque = new ArrayDeque<>();
        deque.add(new P(0, 0, firstCost));
        while (!deque.isEmpty()) {
            P p = deque.pollFirst();
            if (p.r == h-1 && p.c == w-1) {
                System.out.println(p.cost);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nextR = p.r+nextX[i];
                int nextC = p.c+nextY[i];
                if (nextR == h || nextC == w) {
                    continue;
                }
                if (s[p.r][p.c] == '.' &&s[nextR][nextC] == '#') {
                    if (costs[nextR][nextC] > p.cost+1) {
                        costs[nextR][nextC] = p.cost+1;
                        deque.addLast(new P(nextR, nextC, p.cost+1));
                    }
                } else {
                    if (costs[nextR][nextC] > p.cost) {
                        costs[nextR][nextC] = p.cost;
                        deque.addFirst(new P(nextR, nextC, p.cost));
                    }
                }
            }
        }

        out.flush();
    }

    private static class P {
        int r;
        int c;
        int cost;
        public P(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
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