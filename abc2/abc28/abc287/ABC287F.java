import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ABC287F {

    private static final int MOD = 998244353;
    private static List<Integer>[] tree;

    private static BiFunction<Long, Long, Long> merge = (l1, l2) -> (l1+l2)%MOD;

    public static void main(String[] args) {
        int n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            tree[u].add(v);
            tree[v].add(u);
        }
        Result result = dfs(0, -1);
        for (int i = 1; i <= n; i++) {
            out.println((result.yMap.getOrDefault(i, 0L) + result.nMap.getOrDefault(i, 0L)) % MOD);
        }

        out.flush();
    }

    private static Result dfs(int current, int prev) {

        Result res = new Result(new HashMap<>(), new HashMap<>());
        res.nMap.put(0, 1L);
        res.yMap.put(1, 1L);
        for (Integer next : tree[current]) {
            if (prev == next) continue;
            Result result = dfs(next, current);
            Result newRes = new Result(new HashMap<>(), new HashMap<>());

            res.yMap.forEach((k, v) -> {
                result.nMap.forEach((k1, v1) -> {
                        newRes.yMap.merge(k+k1, v*v1%MOD, merge);
                });
                result.yMap.forEach((k1, v1) -> {
                    if (k+k1-1>=0) {
                        newRes.yMap.merge(k+k1-1, v*v1%MOD, merge);
                    }
                });
            });

            res.nMap.forEach((k, v) -> {
                result.nMap.forEach((k1, v1) -> {
                        newRes.nMap.merge(k+k1, v*v1%MOD, merge);
                });
                result.yMap.forEach((k1, v1) -> {
                        newRes.nMap.merge(k+k1, v*v1%MOD, merge);
                });
            });
            res = newRes;
        }

        return res;
    }



    private static class Result {
        Map<Integer, Long> yMap;
        Map<Integer, Long> nMap;
        public Result(Map<Integer, Long> yMap, Map<Integer, Long> nMap) {
            this.yMap = yMap;
            this.nMap = nMap;
        }
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