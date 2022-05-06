package again;

import java.io.*;
import java.util.*;

public class Q39_TreeDistance {

    private static int n;
    private static List<Integer>[] tree;
    private static long ans;

    public static void main(String[] args) {
        n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(0, -1);
        out.println(ans);
        out.flush();
    }

    private static long dfs(int current, int prev) {
        long count = 1;
        for (Integer next : tree[current]) {
            if (prev == next) continue;
            count += dfs(next, current);
        }
        ans += (n-count)*count;
        return count;
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