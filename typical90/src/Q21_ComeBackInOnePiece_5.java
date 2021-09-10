import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q21_ComeBackInOnePiece_5 {

    private static ArrayList<Integer>[] g;
    private static ArrayList<Integer>[] gi;
    private static int n;

    private static boolean[] done0;
    private static boolean[] done1;

    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();

        g = new ArrayList[n];
        gi = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
            gi[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            gi[b].add(a);
        }

        done0 = new boolean[n];
        done1 = new boolean[n];

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!done0[i]) {
                dfs0(i, q);

            }
        }

        long ans = 0;

        while (!q.isEmpty()) {
            int node = q.pollLast();
            if (!done1[node]) {
                HashSet<Integer> group = new HashSet<>();
                dfs1(node, group);
                int size = group.size();
                ans += (((long) size * (size-1)) / 2);
            }
        }

        out.println(ans);
        out.flush();
    }

    static void dfs0(int node, Deque<Integer> q) {
        if (done0[node]) return;
        done0[node] = true;
        for (final int next : g[node]) {
            dfs0(next, q);
        }
        q.add(node);
    }

    static void dfs1(int node, Set<Integer> group) {
        if (done1[node]) return;
        done1[node] = true;
        group.add(node);
        for (final int next : gi[node]) {
            dfs1(next, group);
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