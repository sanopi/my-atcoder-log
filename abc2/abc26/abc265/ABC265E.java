import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC265E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long d = nextLong();
        long e = nextLong();
        long f = nextLong();
        Map<Long, Set<Long>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long x = nextInt();
            long y = nextInt();
            Set<Long> set = map.getOrDefault(x, new HashSet<>());
            set.add(y);
            map.put(x, set);
        }
        long[][][] dp = new long[n+1][n+1][n+1];
        dp[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i+j>=n) {
                    break;
                }
                for (int k = 0; k < n; k++) {
                    if (i+j+k>=n) {
                        break;
                    }
                    long x = a*i+c*j+e*k;
                    long y = b*i+d*j+f*k;
                    if (!map.getOrDefault(x+a, Set.of()).contains(y+b)) {
                        // iを+1
                        dp[i+1][j][k] += dp[i][j][k];
                        dp[i+1][j][k] %= MOD;
                    }
                    if (!map.getOrDefault(x+c, Set.of()).contains(y+d)) {
                        // jを+1
                        dp[i][j+1][k] += dp[i][j][k];
                        dp[i][j+1][k] %= MOD;

                    }
                    if (!map.getOrDefault(x+e, Set.of()).contains(y+f)) {
                        // kを+1
                        dp[i][j][k+1] += dp[i][j][k];
                        dp[i][j][k+1] %= MOD;
                    }

                }
            }
        }
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int k = n-i-j;
                if (k<0) {
                    continue;
                }
                ans += dp[i][j][k];
                ans %= MOD;
            }
        }
        out.println(ans);
        out.flush();
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