package again;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q26_IndependentSetOnATree {

    public static void main(String[] args) {
        int n = nextInt();
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        dfs(0, -1, tree, set1, set2, true);

        Set<Integer> ans = set1.size()>=set2.size()? set1: set2;
        ans.stream().limit(n/2).forEach(i -> out.print(i+1 + " "));
        out.println();
        out.flush();
    }

    private static void dfs(int current, int prev, List<Integer>[] tree, Set<Integer> set1, Set<Integer> set2, boolean one) {
        if (one) set1.add(current);
        else set2.add(current);

        for (Integer next : tree[current]) {
            if (prev == next) continue;
            dfs(next, current, tree, set1, set2, !one);
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