import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC216F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(n);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(a[i], b[i]);
        }
        Arrays.sort(pairs, Comparator.comparing((Pair p) -> p.a).thenComparing(p -> p.b));

        long[][] dp = new long[n+1][5001];
        dp[0][0] = 1;
        long[] tmp = new long[5001];
        tmp[0] = 1;
        for (int i = 0; i < n; i++) {
            Pair p = pairs[i];
            for (int j = 0; j+p.b <= 5000; j++) {
                dp[i+1][j+p.b] = tmp[j];
            }
            for (int j = 0; j < 5001; j++) {
                tmp[j] += dp[i+1][j];
                tmp[j] %= MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            Pair p = pairs[i];
            for (int j = 1; j <= p.a; j++) {
                ans += dp[i+1][j];
                ans %= MOD;
            }
        }

        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
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