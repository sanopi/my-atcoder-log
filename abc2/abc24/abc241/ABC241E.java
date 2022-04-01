import java.io.PrintWriter;
import java.util.Scanner;

public class ABC241E {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        int[] a = nextIntArray(n);
        long ans;
//        ans = solve1(n, k, a);
        ans = solve2(n, k, a);
        out.println(ans);
        out.flush();
    }

    private static long solve2(int n, long k, int[] a) {
        int size = 63;
        long[][] dp = new long[size][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = a[i];
        }
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < n; j++) {
                long midPoint = j + dp[i][j]; // j から、 2^i回操作を行った時の数。
                // j -2^i-> midPoint -2^i-> dp[i+1][j]
                if (midPoint < 0) {
                    break;
                }
                dp[i+1][j] = dp[i][j] + dp[i][(int)(midPoint%n)];
            }
        }

        long ans = 0;
        for (int i = 63 - 1; i >= 0; i--) {
            if ((k&1L<<i) != 0) {
                ans += dp[i][(int)(ans%n)];
            }
        }
        return ans;
    }

    private static long solve1(int n, long k, int[] a) {
        Pair[] counts = new Pair[n];
        // 0（mod N）個キャンディーがある状態が最初にあわられるのは、0回の操作後で実際に0個乗っている
        counts[0] = new Pair(0, 0);

        long candies = a[0];
        int i = 1;
        while (i< k && counts[(int)(candies% n)] == null) {
            counts[(int)(candies% n)] = new Pair(i, candies);
            int ap = a[(int)(candies% n)];
            candies += ap;
            i++;
        }
        k -=i;
        if (k ==0) {
            return candies;
        }

        Pair prev = counts[(int) (candies % n)];
        candies += k /(i-prev.i) * (candies - prev.candyCount);
        k = k %(i-prev.i);

        while (k--> 0) {
            candies += a[(int)(candies% n)];
        }
        return candies;
    }

    private static class Pair {
        int i;
        long candyCount;
        public Pair(int i, long candyCount) {
            this.i = i;
            this.candyCount = candyCount;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "i=" + i +
                ", candyCount=" + candyCount +
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