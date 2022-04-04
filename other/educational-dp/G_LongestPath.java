import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class G_LongestPath {

    private static int n;
    private static int m;
    private static ArrayList<Integer>[] g;

    private static int[] lengths;

    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();
        g = new ArrayList[n];
        lengths = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            g[nextInt() - 1].add(nextInt() - 1);
        }
        // 実質一緒。再帰の中でやるか別でやるかの違い
//        memoRec();
//        topologicalAndDp();
        // 違う実装
        topologicalAndDp2();
    }
    private static void topologicalAndDp() {
        boolean[] done = new boolean[n];
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!done[i]) {
                sort(i, sorted, done);
            }
        }

        for (int i = 0; i < sorted.size(); i++) {
            Integer current = sorted.get(i);
            for (final Integer next : g[current]) {
                lengths[current] = Math.max(lengths[current], lengths[next]+1);
            }
        }
        out.println(Arrays.stream(lengths).max().orElseThrow());
        out.flush();
    }

    private static void sort(int current, List<Integer> list, boolean[] done) {
        for (final Integer next : g[current]) {
            if (!done[next]) {
                dfs(next);
            }
        }
        list.add(current);
        done[current] = true;
    }

    private static void topologicalAndDp2() {
        List<Integer> sorted = tSort(g);
        for (int i = sorted.size()-1; i >= 0; i--) {
            Integer current = sorted.get(i);
            for (final Integer next : g[current]) {
                lengths[current] = Math.max(lengths[current], lengths[next]+1);
            }
        }
        out.println(Arrays.stream(lengths).max().orElseThrow());
        out.flush();
    }

    private static List<Integer> tSort(List<Integer>[] graph) {
        int[] inCount = new int[graph.length];
        for (List<Integer> nexts : graph) { for (Integer next : nexts) { inCount[next]++; } }
        // 必要に応じてPriorityQueueなどを使う
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) { if (inCount[i]==0) q.add(i); }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer node = q.poll();
            result.add(node);
            for (final Integer next : graph[node]) {
                inCount[next]--;
                if (inCount[next] == 0) { q.add(next); }
            }
        }
        return result;
    }

    private static void memoRec() {
        for (int i = 0; i < n; i++) {
            if (lengths[i] == 0) {
                dfs(i);
            }
        }
        out.println(Arrays.stream(lengths).max().orElseThrow());
        out.flush();
    }

    private static void dfs(int current) {
        for (final Integer next : g[current]) {
            if (lengths[next] == 0) {
                dfs(next);
            }
            lengths[current] = Math.max(lengths[current], lengths[next] + 1);
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