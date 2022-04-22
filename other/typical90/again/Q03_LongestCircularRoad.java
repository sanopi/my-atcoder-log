package again;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q03_LongestCircularRoad {

    private static List<Integer>[] tree;
    public static void main(String[] args) {
        int n = nextInt();
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
        Pair far = dfs_node(new Pair(0, 0), -1);
        Pair result = dfs_node(new Pair(far.node, 0), -1);
        out.println(result.distance+1);
        out.flush();
    }

    private static Pair dfs_node(Pair current, int prev) {
        Pair res = current;
        for (Integer next : tree[current.node]) {
            if (next.equals(prev)) continue;
            Pair result = dfs_node(new Pair(next, current.distance + 1), current.node);
            if (res.distance < result.distance) {
                res = result;
            }
        }
        return res;
    }

    private static class Pair {
        int node;
        int distance;
        public Pair(int node, int distance) {
            this.node = node;
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