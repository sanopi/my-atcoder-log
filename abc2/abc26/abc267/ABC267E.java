import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ABC267E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long[] a = nextLongArray(n);
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }

        long[] costs = new long[n];
        for (int i = 0; i < n; i++) {
            for (Integer next : g[i]) {
                costs[i] += a[next];
            }
        }

        long ans;
//        ans = solve1(n, a, g, Arrays.copyOf(costs, n));
        ans = solve2(n, a, g, Arrays.copyOf(costs, n));

        out.println(ans);
        out.flush();
    }
    private static long solve2(int n, long[] a, List<Integer>[] g, long[] costs) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing((Pair p) -> p.c).thenComparing(p -> -a[p.i]));
        for (int i = 0; i < n; i++) {
            pq.add(new Pair(i, costs[i]));
        }
        boolean[] deleted = new boolean[n];
        long ans = 0;
        while (!pq.isEmpty()) {
            Pair c = pq.poll();
            int ci = c.i;
            long cc = c.c;
            if (deleted[ci]) continue;
            if (cc != costs[ci]) continue;
            deleted[ci] = true;
            ans = Math.max(ans, costs[ci]);
            for (Integer next : g[ci]) {
                costs[next] -= a[ci];
                pq.add(new Pair(next, costs[next]));
            }
        }
        return ans;
    }

    private static final class Pair {
        int i;
        long c;
        public Pair(int i, long c) {
            this.i = i;
            this.c = c;
        }
    }

    private static long solve1(int n, long[] a, List<Integer>[] g, long[] costs) {
        long ok = Long.MAX_VALUE/2;
        long ng = -1;
        while (ok-ng>1){
            long mid = (ok+ng)/2;
            long[] copied = Arrays.copyOf(costs, n);
            Queue<Integer> toDelete = new ArrayDeque<>();
            Queue<Integer> stay = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (copied[i] <= mid) {
                    toDelete.add(i);
                } else {
                    stay.add(i);
                }
            }
            while (toDelete.size() > 0) {
                while (toDelete.size()>0) {
                    Integer current = toDelete.poll();
                    for (Integer next : g[current]) {
                        copied[next] -= a[current];
                    }
                }
                Queue<Integer> nextStay = new ArrayDeque<>();
                while (stay.size()>0) {
                    Integer current = stay.poll();
                    if (copied[current] <= mid) {
                        toDelete.add(current);
                    } else {
                        nextStay.add(current);
                    }
                }
                stay = nextStay;
            }
            if (stay.size() == 0) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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