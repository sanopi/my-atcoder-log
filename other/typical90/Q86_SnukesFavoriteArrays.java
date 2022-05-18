import java.io.PrintWriter;
import java.util.Scanner;

public class Q86_SnukesFavoriteArrays {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] x = new int[q];
        int[] y = new int[q];
        int[] z = new int[q];
        long[] w = new long[q];
        for (int i = 0; i < q; i++) {
            x[i] = nextInt()-1;
            y[i] = nextInt()-1;
            z[i] = nextInt()-1;
            w[i] = nextLong();
        }

        long ans = 1;
        for (int i = 0; i < 60; i++) {
            int count = 0;
            for (int j = 0; j < 1 << n; j++) {
                boolean ok = true;
                for (int k = 0; k < q; k++) {
                    int xx = Math.min(j & (1<<x[k]), 1);
                    int yy = Math.min(j & (1<<y[k]), 1);
                    int zz = Math.min(j & (1<<z[k]), 1);
                    int ww = (int)Math.min(w[k] & (1L<<i), 1);
                    if ((xx | yy | zz) != ww) ok = false;
                }
                if (ok) count++;
            }
            ans *= count;
            ans %= MOD;
        }
        out.println(ans);
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