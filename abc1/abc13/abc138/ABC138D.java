import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC138D {

    private static int[] ans;
    private static List<Integer>[] tree;
    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        ans = new int[n];
        for (int i = 0; i < q; i++) {
            int p = nextInt()-1;
            int x = nextInt();
            ans[p]+=x;
        }
        dfs(0, -1);
        for (int a : ans) {
            out.print(a+" ");
        }
        out.flush();
    }

    private static void dfs(int current, int prev) {
        for (Integer next : tree[current]) {
            if (next == prev) {
                continue;
            }
            ans[next]+=ans[current];
            dfs(next, current);
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