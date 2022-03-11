import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC126D {

    private static int[] ans;
    private static List<Branch>[] tree;
    public static void main(String[] args) {
        int n = nextInt();
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            int w = nextInt();
            tree[u].add(new Branch(v, w));
            tree[v].add(new Branch(u, w));
        }
        ans = new int[n];
        dfs(0, -1, Color.WHITE);
        for (int an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static void dfs(int current, int prev, Color color) {
        ans[current] = color.num;
        for (Branch next : tree[current]) {
            if (next.to == prev) continue;
            dfs(next.to, current, next.distance%2==0?color:color.other());
        }
    }

    private enum Color {
        WHITE(0),
        BLACK(1),
        ;
        int num;
        Color(int num) {
            this.num = num;
        }
        private Color other() {
            return this.equals(WHITE) ? BLACK : WHITE;
        }
    }

    private static class Branch {
        int to;
        int distance;
        public Branch(int to, int distance) {
            this.to = to;
            this.distance = distance;
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