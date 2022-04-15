import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC247F {

    private static List<Integer>[] g;
    private static long[] memo = new long[222222];

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        int[] p = new int[n];
        int[] q = new int[n];
        for (int i = 0; i < n; i++) p[i] = nextInt() - 1;
        for (int i = 0; i < n; i++) q[i] = nextInt() - 1;
        for (int i = 0; i < n; i++) {
            g[p[i]].add(q[i]);
            g[q[i]].add(p[i]);
        }
        List<Integer> nums = new ArrayList<>();
        boolean[] done = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (done[i]) continue;
            Set<Integer> set = new HashSet<>();
            dfs(i, set);
            for (Integer integer : set) done[integer] = true;
            nums.add(set.size());
        }

        long ans = 1;
        for (Integer num : nums) {
            ans *= solve(num);
            ans%=MOD;
        }
        out.println(ans);
        out.flush();
    }

    private static void dfs(int current, Set<Integer> set) {
        set.add(current);
        for (Integer next : g[current]) {
            if (set.contains(next)) continue;
            dfs(next, set);
        }
    }

    private static long solve(int n) {
        if (n==1) {
            return 1;
        }
        if (n==2) {
            return 3;
        }
        if (n==3) {
            return 4;
        }

        return (solveSub(n) + solveSub(n-2))%MOD;
    }



    private static long solveSub(int n) {
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        if (memo[n] > 0) {
            return memo[n];
        }
        memo[n] = (solveSub(n-1) + solveSub(n-2))%MOD;
        return memo[n];
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