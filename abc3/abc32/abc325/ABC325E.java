import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.BiFunction;

public class ABC325E {

    private static int n;
    private static void solve() {
        n = nextInt();
        long a = nextInt();
        long b = nextInt();
        long c = nextInt();
        long[][] d = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = nextInt();
            }
        }
        long[] carCost = calc(0, (ci, ni) -> d[ci][ni]*a);
        long[] trainCost = calc(n-1, (ci, ni) -> d[ci][ni]*b + c);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, carCost[i]+trainCost[i]);
        }
        out.println(ans);
        out.flush();
    }

    private static long[] calc(int s, BiFunction<Integer, Integer, Long> calcCost) {
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[s] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(pair -> pair.c));
        pq.add(new Pair(s, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int ci = current.i;
            long cc = current.c;
            if (cc != cost[ci]) continue;
            for (int ni = 0; ni < n; ni++) {
                if (ci == ni) continue;
                long nc = cc + calcCost.apply(ci, ni);
                if (cost[ni] <= nc) continue;
                cost[ni] = nc;
                pq.add(new Pair(ni, nc));
            }
        }
        return cost;
    }

    private static class Pair {
        int i;
        long c;
        public Pair(int i, long c) {
            this.i = i;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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