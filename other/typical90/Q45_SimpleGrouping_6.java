import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Q45_SimpleGrouping_6 {

    private static Pair[] pairs;
    private static long[][] memo;
    private static final long INF = Long.MAX_VALUE / 2;
    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }
        setupMemo(n, k);

        out.println(solve(n, (1<<n)-1, k));
//        out.println(solve2(n, k));
        out.flush();
    }


    private static long solve(int n, int indice, int k) {
        if (memo[k][indice] >= 0) {
            return memo[k][indice];
        }
        int size = Integer.bitCount(indice);
        if (size == k) {
            return 0;
        }
        if (k==1) {
            long res = 0;
            for (int i = 0; i < n; i++) {
                if ((indice & (1<<i)) == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    if ((indice & (1<<j)) == 0) continue;
                    res = Math.max(res, pairs[i].calc(pairs[j]));
                }
            }
            return memo[k][indice] = res;
        }
        long res = INF;

        for (int i = indice; i > 0; i = (i-1)&indice) {
            int j = indice ^ i;
            for (int kk = 1; kk < k; kk++) {
                if (Integer.bitCount(i) < kk || Integer.bitCount(j) < k-kk) continue;
                res = Math.min(res, Math.max(solve(n, i, kk), solve(n, j, k-kk)));
            }
        }

        return memo[k][indice] = res;
    }

    private static void setupMemo(int n, int k) {
        memo = new long[k +1][1<< n];
        for (int i = 0; i < k +1; i++) {
            Arrays.fill(memo[i], -1L);
        }

        memo[1] = calcMinimum(n);
    }

    private static long[] calcMinimum(int n) {
        long[] minimum = new long[1<< n];
        for (int i = 1; i < 1 << n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i&(1<<j)) != 0) {
                    list.add(j);
                }
            }
            long result = 0;
            for (int index1 : list) {
                for (int index2 : list) {
                    if (index1 == index2) continue;
                    result = Math.max(result, pairs[index1].calc(pairs[index2]));
                }
            }
            minimum[i] = result;
        }
        return minimum;
    }

    private static class Pair {
        long x;
        long y;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
        private long calc(Pair other) {
            long xDiff = this.x-other.x;
            long yDiff = this.y-other.y;
            return xDiff*xDiff + yDiff*yDiff;
        }
    }

    private static long solve2(int n, int k) {
        long[][] dp = new long[k+1][1<<n];
        for (int i = 0; i < k + 1; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE/2);
        }

        dp[1] = calcMinimum(n);

        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {

                int rest = ((1<<n)-1) ^ j;
                for (int l = rest; l > 0; l = (l-1)&rest) {
                    dp[i+1][j|l] = Math.min(dp[i+1][j|l], Math.max(dp[i][j], dp[1][l]));
                }
            }
        }
        return dp[k][(1<<n)-1];
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