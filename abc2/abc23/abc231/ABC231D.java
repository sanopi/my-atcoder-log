import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ABC231D {

    private static ArrayList<Integer>[] g;
    private static boolean[] done;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        for (final ArrayList<Integer> integers : g) {
            if (integers.size() >= 3) {
                System.out.println("No");
                return;
            }
        }

        done = new boolean[n];
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (done[i]) continue;
            ok = ok && dfs(i, -1);
        }

        out.println(ok?"Yes":"No");
        out.flush();
    }

    private static boolean dfs(int current, int prev) {
        done[current] = true;

        boolean res = true;
        for (final Integer next : g[current]) {
            if (next == prev) continue;
            if (done[next]) return false;
            res = res && dfs(next, current);
        }
        return res;
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