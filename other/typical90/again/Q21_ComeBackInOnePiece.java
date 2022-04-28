package again;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q21_ComeBackInOnePiece {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[] g = new List[n];
        List<Integer>[] revG = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) revG[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            g[a].add(b);
            revG[b].add(a);
        }
        long ans = 0;
        for (Set<Integer> scc : getSCCs(g, revG)) {
            ans += (long)scc.size() * (scc.size()-1) / 2;
        }
        out.println(ans);
        out.flush();
    }

    private static List<Set<Integer>> getSCCs(List<Integer>[] g, List<Integer>[] revG) {
        int n = g.length;
        boolean[] done = new boolean[n];
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!done[i]) {
                Deque<Integer> q = new ArrayDeque<>();
                decideOrder_dfs(i, g, q, done);
                order.addAll(q);
            }
        }

        List<Set<Integer>> res = new ArrayList<>();
        boolean[] done2 = new boolean[n];
        while (!order.isEmpty()) {
            Integer last = order.pollLast();
            Set<Integer> scc = new HashSet<>();
            getSCC_dfs(last, revG, scc, done2);
            res.add(scc);
        }
        return res;
    }

    private static void decideOrder_dfs(int current, List<Integer>[] g, Deque<Integer> queue, boolean[] done) {
        done[current] = true;
        for (Integer next : g[current]) {
            if (done[next]) continue;
            decideOrder_dfs(next, g, queue, done);
        }
        queue.add(current);
    }

    private static void getSCC_dfs(int current, List<Integer>[] revG, Set<Integer> set, boolean[] done) {
        if (done[current]) return;
        done[current] = true;
        set.add(current);
        for (Integer next : revG[current]) {
            getSCC_dfs(next, revG, set, done);
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