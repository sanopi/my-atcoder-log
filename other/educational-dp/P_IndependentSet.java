import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P_IndependentSet {

    private static final int MOD = 1000000007;

    private static List<Integer>[] tree;
    private static long[][] memo;
    public static void main(String[] args) {
        int n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            tree[x].add(y);
            tree[y].add(x);
        }

        memo = new long[2][n];

        long ans = 0;
        ans += dfs(0, -1, 0);
        ans += dfs(0, -1, 1);
        out.println(ans%MOD);
        out.flush();
    }

    private static long dfs(int current, int prev, int color) {
        if (memo[color][current]>0) {
            return memo[color][current];
        }
        long res = 1;
        for (Integer next : tree[current]) {
            if (next==prev) {
                continue;
            }
            long tmp = 0;
            tmp += dfs(next, current, 0);
            if (color!=1) {
                tmp += dfs(next, current, 1);
            }
            res *= tmp%MOD;
            res%=MOD;
        }
        return memo[color][current] = res %MOD;
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