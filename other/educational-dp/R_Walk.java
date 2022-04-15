import java.io.PrintWriter;
import java.util.Scanner;

public class R_Walk {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();

        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = nextInt();
            }
        }

        int[][] ansMatrix = modPow(a, k, MOD);

        int ans = 0;
        for (int[] ints : ansMatrix) {
            for (int i : ints) {
                ans += i;
                ans %= MOD;
            }
        }
        out.println(ans);
        out.flush();
    }

    private static int[][] modPow(int[][] a, long n, int mod) {
        int index = 0;
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }

        while (1L<<index <= n) {
            if ((1L<<index & n) != 0) {
                res = modMultiply(res, a, mod);
            }
            a = modMultiply(a, a, mod);
            index++;
        }
        return res;
    }

    private static int[][] modMultiply(int[][] a, int[][] b, int mod) {
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += ((long)a[i][k]*b[k][j])%mod;
                    res[i][j]%=mod;
                }
            }
        }
        return res;
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