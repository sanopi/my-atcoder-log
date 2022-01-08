import java.io.PrintWriter;
import java.util.Scanner;

public class Q42_MultipleOf9_4 {

    public static void main(String[] args) {
        int k = nextInt();
        if (k % 9 != 0) {
            out.println(0);
            out.flush();
            return;
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int j = Math.max(0, i-9); j < i; j++) {
                dp[i] = (dp[i] + dp[j]) % 1000000007;
            }
        }

        out.println(dp[k]);
        out.flush();
    }

    private static long modPow(int a, int n, int mod) {
        long[] exps = new long[32];
        exps[0] = a;
        long res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
                res = (res * exps[i]) % mod;
            }
            exps[i+1] = (exps[i] * exps[i]) % mod;
            i += 1;
        }

        return res;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
}