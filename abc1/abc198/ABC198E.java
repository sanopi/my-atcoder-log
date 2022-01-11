import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC198E {

    private static final Map<Integer, Integer> appeared = new HashMap();
    private static ArrayList<Integer>[] tree;
    private static int[] c;

    private static boolean[] ans;

    public static void main(String[] args) {
        int n = nextInt();
        c = nextIntArray(n);
        tree = new ArrayList[n];

        for (int i = 0; i<n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }

        ans = new boolean[n];
        dfs(0, -1);

        for (int i = 0; i < ans.length; i++) {
            if (ans[i]) out.println(i+1);
        }
        out.flush();
    }

    private static void dfs(int current, int prev) {
        ans[current] = appeared.getOrDefault(c[current], 0) == 0;
        appeared.put(c[current], appeared.getOrDefault(c[current], 0)+1);
        for (Integer next : tree[current]) {
            if (next.equals(prev)) continue;
            dfs(next, current);
        }
        appeared.put(c[current], appeared.getOrDefault(c[current], 0)-1);
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