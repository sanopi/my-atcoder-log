import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC237F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int ans;
//        ans = solve1(n, m);
        ans = solve2(n, m);
        out.println(ans);
        out.flush();
    }
    private static int solve2(int n, int m) {
        int[][][][] dp = new int[n+1][m+1][m+1][m+1];
        dp[0][m][m][m] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m+1; j++) {
                for (int k = j; k < m+1; k++) {
                    for (int l = k; l < m+1; l++) {
                        for (int x = 0; x < m; x++) {
                            if (x<=j) dp[i+1][x][k][l] = (dp[i+1][x][k][l] + dp[i][j][k][l])%MOD;
                            else if (x <= k) dp[i+1][j][x][l] = (dp[i+1][j][x][l] + dp[i][j][k][l])%MOD;
                            else if (x <= l) dp[i+1][j][k][x] = (dp[i+1][j][k][x] + dp[i][j][k][l])%MOD;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    ans += dp[n][i][j][k];
                    ans %= MOD;
                }
            }
        }
        return ans;
    }

    private static int solve1(int n, int m) {
        Map<Fixture, Integer>[][] dp = new Map[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (i == 0) {
                    int[] lis = new int[10];
                    Arrays.fill(lis, 11);
                    lis[0] = j;
                    dp[i][j].put(new Fixture(lis, 1), 1);
                } else {
                    List<Map.Entry<Fixture, Integer>> entries = Arrays.stream(dp[i - 1]).flatMap(map -> map.entrySet().stream()).collect(Collectors.toList());
                    for (Map.Entry<Fixture, Integer> entry : entries) {
                        Fixture prev = entry.getKey();
                        int k = 0;
                        while (k < 10) {
                            if (prev.lis[k] >= j) {
                                break;
                            }
                            k++;
                        }
                        int[] nextLis = Arrays.copyOf(prev.lis, prev.lis.length);
                        nextLis[k] = j;
                        int nextLength = Math.max(prev.length, k + 1);
                        if (nextLength > 3) {
                            continue;
                        }
                        Fixture next = new Fixture(nextLis, nextLength);
                        dp[i][j].put(next, (dp[i][j].getOrDefault(next, 0)+entry.getValue())%MOD);
                    }
                }

            }
        }
        long[] longs = Arrays.stream(dp[n - 1]).flatMap(map -> map.entrySet().stream()).filter(entry -> entry.getKey().length == 3).mapToLong(entry -> entry.getValue()).toArray();
        int ans = 0;
        for (long aLong : longs) {
            ans += aLong;
            ans %= MOD;
        }
        return ans;
    }

    private static class Fixture {
        int[] lis;
        int length;
        public Fixture(int[] lis, int length) {
            this.lis = lis;
            this.length = length;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Fixture fixture = (Fixture) o;

            if (length != fixture.length) return false;
            return Arrays.equals(lis, fixture.lis);
        }
        @Override
        public int hashCode() {
            int result = Arrays.hashCode(lis);
            result = 31 * result + length;
            return result;
        }
        @Override
        public String toString() {
            return "Fixture{" +
                "lis=" + Arrays.toString(lis) +
                ", length=" + length +
                '}';
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