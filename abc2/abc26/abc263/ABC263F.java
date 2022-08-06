import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ABC263F {

    private static int n;
    private static long[][] win;
    private static long[][] memo;
    private static Map<Pair, Long> map;

    public static void main(String[] args) {
        n = nextInt();
        int num = 1<< n;
        win = new long[num][n+1];
        for (int i = 0; i < num; i++)  {
            for (int j = 0; j < n; j++) {
                win[i][j+1] = nextInt();
            }
        }

        long ans = 0;
        memo = new long[num][n+1];
        map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            ans = Math.max(ans, solve(i, n, 0, num-1));
        }

        out.println(ans);
        out.flush();
    }

    private static long solve(int player, int round, int l, int r) {
        if (memo[player][round] > 0) {
            return memo[player][round];
        }
        if (round == 0) {
            return 0;
        }
        int rl = (l + r + 1) / 2;
        int a = l;
        int b = rl-1;
        int c = rl;
        int d = r;
        if (a<=player && player<=b) {
            long res = solve(player, round-1, a, b) + win[player][round] - (win[player][round-1]);
            long add = 0;
            Long cd = map.get(new Pair(c, d));
            if (cd == null) {
                for (int i = c; i <= d; i++) {
                    add = Math.max(add, solve(i, round-1, c, d));
                }
                map.put(new Pair(c,d), add);
            } else {
                add = cd;
            }

            return memo[player][round] = res + add;
        } else {
            long res = solve(player, round-1, c, d) + win[player][round] - (win[player][round-1]);
            long add = 0;
            Long ab = map.get(new Pair(a, b));
            if (ab != null) {
                add = ab;
            } else {
                for (int i = a; i <= b; i++) {
                    add = Math.max(add, solve(i, round-1, a, b));
                }
                map.put(new Pair(a,b), add);
            }
            return memo[player][round] = res + add;
        }
    }

    private static class Pair {
        int l;
        int r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return l == pair.l && r == pair.r;
        }
        @Override
        public int hashCode() {
            return Objects.hash(l, r);
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