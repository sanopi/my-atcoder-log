import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q7_LongestPath {

    private static int n;
    private static int m;
    private static ArrayList<Integer>[] g;

    private static int[] lengths;

    public static void main(String[] args) {
        // 実質一緒。再帰の中でやるか別でやるかの違い
        memoRec();
//        topologicalAndDp();
    }
    private static void topologicalAndDp() {
        n = nextInt();
        m = nextInt();
        g = new ArrayList[n];
        lengths = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt() - 1;
            int y = nextInt() - 1;
            g[x].add(y);
        }

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

    private static void memoRec() {
        n = nextInt();
        m = nextInt();
        g = new ArrayList[n];
        lengths = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            g[nextInt()-1].add(nextInt()-1);
        }
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