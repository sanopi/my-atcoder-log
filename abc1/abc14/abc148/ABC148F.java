import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC148F {

    private static int[] aokiDist;
    private static boolean[] takahashiDist;
    private static List<Integer>[] tree;

    public static void main(String[] args) {
        int n = nextInt();
        int u = nextInt()-1;
        int v = nextInt()-1;
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        aokiDist = new int[n];
        fillAokiDist(v, -1, 0);
        takahashiDist = new boolean[n];
        fillTakahashiDist(u, -1, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (takahashiDist[i] && tree[i].size() > 1) {
                ans = Math.max(ans, aokiDist[i]);
            }
        }

        out.println(ans);
        out.flush();
    }

    private static void fillAokiDist(int current, int prev, int dist) {
        aokiDist[current] = dist;
        for (Integer next : tree[current]) {
            if (next == prev) continue;
            fillAokiDist(next, current, dist+1);
        }
    }

    private static void fillTakahashiDist(int current, int prev, int dist) {
        takahashiDist[current] = true;
        if (aokiDist[current] <= dist) {
            return;
        }

        for (Integer next : tree[current]) {
            if (next == prev) continue;
            fillTakahashiDist(next, current, dist+1);
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