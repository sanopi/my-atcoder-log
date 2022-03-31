import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC240E {

    private static int[] ls;
    private static int[] rs;
    private static int max = 0;
    private static List<Integer>[] tree;

    public static void main(String[] args) {
        int n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            tree[u].add(v);
            tree[v].add(u);
        }
        ls = new int[n];
        rs = new int[n];

        dfs(0, -1);

        for (int i = 0; i < n; i++) {
            out.println(ls[i] + " " + rs[i]);
        }
        out.flush();
    }

    private static void dfs(int current, int prev) {
        if (current!=0 && tree[current].size() == 1) {
            ls[current] = max+1;
            rs[current] = max+1;
            max++;
            return;
        }

        int l = 1000000;
        int r = 0;
        for (Integer next : tree[current]) {
            if (next.equals(prev)) {
                continue;
            }
            dfs(next, current);
            l = Math.min(l, ls[next]);
            r = Math.max(r, rs[next]);
        }
        ls[current] = l;
        rs[current] = r;
        max = Math.max(max, r);
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