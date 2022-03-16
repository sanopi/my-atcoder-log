import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC070D {

    private static List<Path>[] tree;
    private static long[] costToK;

    public static void main(String[] args) {
        int n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            tree[a].add(new Path(b, c));
            tree[b].add(new Path(a, c));
        }

        int q = nextInt();
        int k = nextInt()-1;

        costToK = new long[n];
        dfs(k, -1, 0);

        for (int i = 0; i < q; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            out.println(costToK[x]+costToK[y]);
        }

        out.flush();
    }

    private static void dfs(int current, int prev, long cost) {
        costToK[current] = cost;
        for (Path path : tree[current]) {
            if (path.to == prev) continue;
            dfs(path.to, current, cost+path.c);
        }
    }

    private static class Path {
        int to;
        int c;
        public Path(int to, int c) {
            this.to = to;
            this.c = c;
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