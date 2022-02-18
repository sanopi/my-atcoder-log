import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC079D {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] c = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                c[i][j] = nextInt();
            }
        }

        long ans;
//        ans = solve1(h, w, c);
        ans = solve2(h, w, c);
        out.println(ans);


        out.flush();
    }
    private static long solve2(int h, int w, int[][] c) {
        // ワーシャルフロイド
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    c[i][j] = Math.min(c[i][j], c[i][k] + c[k][j]);
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int a = nextInt();
                ans += (a>=0?c[a][1]:0);
            }
        }
        return ans;
    }
    private static long solve1(int h, int w, int[][] c) {
        int[] cost = new int[10];
        for (int i = 0; i < 10; i++) {
            boolean[] done = new boolean[10];
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p -> p.cost));
            pq.add(new Pair(i, 0));
            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                if (current.i == 1) {
                    cost[i]=current.cost;
                    break;
                }
                done[current.i]=true;
                for (int j = 0; j < 10; j++) {
                    if (done[j]) continue;
                    pq.add(new Pair(j, current.cost + c[current.i][j]));
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int a = nextInt();
                ans += (a>=0?cost[a]:0);
            }
        }
        return ans;
    }

    private static class Pair {
        int i;
        int cost;
        public Pair(int i, int cost) {
            this.i = i;
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