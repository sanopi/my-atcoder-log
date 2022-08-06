import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ABC190E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        int k = nextInt();
        Map<Integer, Integer> ciMap = new HashMap<>();
        int[] c = new int[k];
        for (int i = 0; i < k; i++) {
            c[i] = nextInt()-1;
            ciMap.put(c[i], i);
        }

        int[][] costs = new int[k][k];
        for (int i = 0; i < k; i++) {
            Arrays.fill(costs[i], Integer.MAX_VALUE);
            costs[i][i] = 0;
        }

        for (int i = 0; i < k; i++) {
            boolean[] done = new boolean[n];
            Queue<LastDep> q = new ArrayDeque<>();
            q.add(new LastDep(c[i], 0));
            done[c[i]] = true;
            while (!q.isEmpty()) {
                LastDep current = q.poll();
                int ci = current.i;
                int cd = current.dep;
                for (Integer next : g[ci]) {
                    if (done[next]) continue;
                    done[next] = true;
                    if (ciMap.containsKey(next)) {
                        int ni = ciMap.get(next);
                        costs[i][ni] = Math.min(costs[i][ni], cd+1);
                        costs[ni][i] = Math.min(costs[ni][i], cd+1);
                    }
                    q.add(new LastDep(next, cd+1));
                }
            }
        }

        long[][] ans = new long[1<<k][k];
        for (long[] an : ans) {
            Arrays.fill(an, Long.MAX_VALUE);
        }

        for (int i = 0; i < k; i++) {
            ans[1<<i][i] = 1;
        }
        for (int i = 1; i < 1 << k; i++) {
            for (int j = 0; j < k; j++) {
                if ((i & (1<<j)) == 0) continue;
                int ij = i^(1<<j);
                long min = Long.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (ans[ij][l] != Long.MAX_VALUE) {
                        min = Math.min(min, ans[ij][l] + costs[l][j]);
                    }
                }
                ans[i][j] = Math.min(ans[i][j], min);
            }
        }


        long result = Arrays.stream(ans[(1 << k) - 1]).min().getAsLong();
        out.println(result >= Integer.MAX_VALUE ? "-1" : result);
        out.flush();
    }

    private static class Bit {
        int bit;
        int last;
        int count;
        public Bit(int bit, int last, int count) {
            this.bit = bit;
            this.last = last;
            this.count = count;
        }
    }

    private static class LastDep {
        int i;
        int dep;
        public LastDep(int i, int dep) {
            this.i = i;
            this.dep = dep;
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