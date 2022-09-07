import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC267F {

    private static List<Integer>[] tree;
    private static int[] ans;
    private static List<Query>[] queries;
    private static int[] memo;
    private static int memoSize = 0;

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
        Pair first = dfs(0, -1, 0);
        Pair second = dfs(first.i, -1, 0);

        queries = new List[n];
        for (int i = 0; i < n; i++) {
            queries[i] = new ArrayList<>();
        }

        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int u = nextInt()-1;
            int k = nextInt();
            queries[u].add(new Query(u, k, i));
        }
        ans = new int[q];
        Arrays.fill(ans, -1);
        memo = new int[second.dep+1];
        solve(first.i, -1);
        solve(second.i, -1);

        for (int an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static class Pair {
        int i;
        int dep;
        public Pair(int i, int dep) {
            this.dep = dep;
            this.i = i;
        }
    }

    private static class Query {
        int u;
        int k;
        int i;
        public Query(int u, int k, int i) {
            this.u = u;
            this.k = k;
            this.i = i;
        }
    }

    private static Pair dfs(int current, int prev, int dep) {
        Pair res = new Pair(current, dep);
        for (Integer next : tree[current]) {
            if (prev == next) continue;
            Pair result = dfs(next, current, dep + 1);
            if (result.dep > res.dep) {
                res = result;
            }
        }
        return res;
    }

    private static void solve(int current, int prev) {
        memo[memoSize] = current+1;
        memoSize++;
        for (Query query : queries[current]) {
            if (memoSize-query.k-1>=0) {
                ans[query.i] = memo[memoSize-query.k-1];
            }
        }
        for (Integer next : tree[current]) {
            if (prev == next) continue;
            solve(next, current);
        }
        memoSize--;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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