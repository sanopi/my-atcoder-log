import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ARC143B {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
//        for (int i = 1; i <= 500; i++) {
//            System.out.println(i);
//            solve(i);
//        }
        solve(n);
        out.flush();
    }
    private static void solve(int n) {
        int n2 = n * n;
        long total = fact(n2);

        int len = n2 - n + 1;
        long[] dp = new long[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            long[] tmp = new long[len];
            for (int j = i; j < len; j++) {
                tmp[j] = (tmp[j-1] + dp[j-1])%MOD;
            }
            dp = tmp;
        }
        long sum = 0;
        for (int i = n -1; i < dp.length; i++) {
            long add = (dp[i] * dp[n2-i-1]) %MOD;
            sum += add;
            sum %= MOD;
        }
        long fact = fact(n - 1);
        sum *= fact;
        sum %= MOD;
        sum *= fact;
        sum %= MOD;

        long other = fact((n - 1) * (n - 1));
        sum *= other;
        sum %= MOD;

        sum *= n2;
        sum %= MOD;

        long ans = total - sum;
        out.println((ans+MOD)%MOD);
    }

    private static long fact(int num) {
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }

    private static long modFact(long from, long toEx, int mod) {
        if (from == toEx) {
            return 1;
        }
        return from * modFact(from-1, toEx, mod) % mod;
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