import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC237E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();

        int[] h = nextIntArray(n);
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }

//        out.println(solve1(n, h, g));
        out.println(solve2(n, h, g));
        out.flush();
    }
    private static long solve2(int n, int[] h, ArrayList<Integer>[] g) {
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> cost[i]));
        pq.add(0);
        while (!pq.isEmpty()) {
            int current = pq.poll();
            for (Integer next : g[current]) {
                int diff = h[current] - h[next];
                long nextCost = cost[current] + Math.max(0, -diff);
                if (cost[next] <= nextCost) {
                    continue;
                }
                cost[next] = nextCost;
                pq.add(next);
            }
        }
        for (int i = 0; i < n; i++) {
            cost[i] += h[i];
        }
        return h[0]-Arrays.stream(cost).min().getAsLong();
    }


    /**
     * TLEになる嘘解法
     */
    private static long solve1(int n, int[] h, ArrayList<Integer>[] g) {
        long[] fun = new long[n];
        Arrays.fill(fun, Long.MIN_VALUE);
        fun[0] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(i -> -fun[i]));
        pq.add(0);
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            for (Integer next : g[current]) {

                long nextFun;
                if (h[current] >= h[next]) {
                    nextFun = fun[current] + h[current] - h[next];
                } else {
                    nextFun = fun[current] + (h[current] - h[next]) * 2L;
                }
                if (nextFun > fun[next]) {
                    fun[next] = nextFun;
                    pq.add(next);
                }
            }
        }
        return Arrays.stream(fun).max().getAsLong();
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