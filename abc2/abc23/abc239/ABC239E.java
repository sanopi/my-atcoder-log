import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC239E {

    private static List<Integer>[] tree;
    private static List<Integer>[] ans;
    private static int[] x;
    private static int n;
    private static int q;

    public static void main(String[] args) {
        n = nextInt();
        q = nextInt();
        x = nextIntArray(n);
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            tree[a].add(b);
            tree[b].add(a);
        }

        ans = new List[n];
        dfs(0, -1);

        for (int i = 0; i < q; i++) {
            int v = nextInt()-1;
            int k = nextInt();
            out.println(ans[v].get(k-1));
        }

        out.flush();
    }

    private static List<Integer> dfs(int current, int prev) {
        List<Integer> res = new ArrayList<>();
        res.add(x[current]);
        for (Integer next : tree[current]) {
            if (next == prev) continue;
            res.addAll(dfs(next, current));
        }
        res.sort(Comparator.comparing(i -> -i));
        res = res.subList(0, Math.min(res.size(), 20));
        ans[current] = res;
        return res;
    }

    private static class Query {
        int i;
        int v;
        int k;
        public Query(int i, int v, int k) {
            this.i = i;
            this.v = v;
            this.k = k;
        }
        @Override
        public String toString() {
            return "Query{" +
                "i=" + i +
                ", v=" + v +
                ", k=" + k +
                '}';
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