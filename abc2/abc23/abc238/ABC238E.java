import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC238E {

    private static int n;
    private static List<Integer>[] g;
    private static boolean[] done;
    public static void main(String[] args) {
        n = nextInt()+1;
        int q = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < q; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1+1;
            g[l].add(r);
            g[r].add(l);
        }

        done = new boolean[n];
        System.out.println(dfs(0) ? "Yes" : "No");
        out.flush();
    }

    private static boolean dfs(int current) {
        if (current == n-1) {
            return true;
        }
        if (done[current]) {
            return false;
        }
        done[current] = true;
        boolean res = false;
        for (Integer next : g[current]) {
            res = res || dfs(next);
        }
        return res;
    }

    private static class Pair {
        int l;
        int r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
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