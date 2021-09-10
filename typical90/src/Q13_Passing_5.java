import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q13_Passing_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();

        List<Pair>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            g[a].add(new Pair(b, c));
            g[b].add(new Pair(a, c));
        }

        int[] cost0 = new int[n];
        Arrays.fill(cost0, Integer.MAX_VALUE);
        cost0[0] = 0;

        PriorityQueue<Integer> pq0 = new PriorityQueue<>(Comparator.comparingInt(i -> cost0[i]));
        pq0.add(0);
        while (!pq0.isEmpty()) {
            int i = pq0.poll();
            for (final Pair next : g[i]) {
                if (cost0[i] + next.cost < cost0[next.node]) {
                    cost0[next.node] = cost0[i] + next.cost;
                    pq0.add(next.node);
                }
            }
        }


        int[] costN = new int[n];
        Arrays.fill(costN, Integer.MAX_VALUE);
        costN[n-1] = 0;

        PriorityQueue<Integer> pqN = new PriorityQueue<>(Comparator.comparingInt(i -> cost0[i]));
        pqN.add(n-1);
        while (!pqN.isEmpty()) {
            int i = pqN.poll();
            for (final Pair next : g[i]) {
                if (costN[i] + next.cost < costN[next.node]) {
                    costN[next.node] = costN[i] + next.cost;
                    pqN.add(next.node);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(cost0[i] + costN[i]);
        }
        out.flush();
    }

    private static class Pair {
        int node;
        int cost;
        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        int getCost() {return cost;}
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