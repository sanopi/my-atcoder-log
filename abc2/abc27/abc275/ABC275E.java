import java.io.PrintWriter;
import java.util.Scanner;

public class ABC275E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        long div = modPow(m, MOD - 2, MOD);

        long[][] ans = new long[k+1][n+1];
        ans[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 1; l <= m; l++) {
                    if (j+l > n) {
                        ans[i+1][(n-(j+l-n))] += (ans[i][j] * div)%MOD;
                    } else {
                        ans[i+1][j+l] += (ans[i][j] * div)%MOD;
                        ans[i+1][j+l] %= MOD;
                    }

                }
            }
            ans[i+1][n] += ans[i][n];
            ans[i+1][n] %= MOD;
        }
        out.println(ans[k][n]);
        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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