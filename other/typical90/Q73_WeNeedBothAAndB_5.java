import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q73_WeNeedBothAAndB_5 {

    private static final int MOD = 1000000007;
    private static List<Integer>[] tree;
    private static char[] c;
    private static int n;

    public static void main(String[] args) {
        n = nextInt();
        c = new char[n];
        for (int i = 0; i < n; i++) {
            c[i] = next().charAt(0);
        }
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            tree[x].add(y);
            tree[y].add(x);
        }

        Counts counts = dfs(0, -1);
        out.println((counts.both+MOD)%MOD);
        out.flush();
    }

    private static Counts dfs(int current, int prev) {
        Counts res;
        if (c[current] == 'a') {
            res = new Counts(1, 0, 1);
        } else {
            res = new Counts(0, 1, 1);
        }

        for (Integer next : tree[current]) {
            if (prev == next) continue;
            Counts counts = dfs(next, current);
            res = new Counts(
                res.a * ((counts.a + counts.both)%MOD) % MOD,
                res.b * ((counts.b + counts.both)%MOD) % MOD,
                res.both * ((counts.a + counts.both + counts.b + counts.both)%MOD) % MOD
            );
        }
        res.both -= res.a+res.b;
        res.both%=MOD;
        return res;
    }

    private static class Counts {
        long a;
        long b;
        long both;
        public Counts(long a, long b, long both) {
            this.a = a;
            this.b = b;
            this.both = both;
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