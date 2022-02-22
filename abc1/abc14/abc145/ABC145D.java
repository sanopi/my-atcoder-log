import java.io.PrintWriter;
import java.util.Scanner;

public class ABC145D {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        long x = nextInt();
        long y = nextInt();
        long yyx = 2*y-x;
        long xxy = 2*x-y;
        if (yyx%3!=0 || xxy%3!=0 || yyx<0 || xxy<0) {
            System.out.println(0);
            return;
        }
        long k = yyx/3;
        long l = xxy/3;

        if (Math.min(k, l) == 0) {
            out.println(1);
        } else {
            out.println(fact(k+l, k+1, MOD) * modPow(fact(l, 1, MOD), MOD-2, MOD) % MOD);
        }
        out.flush();
    }

    private static long fact(long a, long b, int MOD) {
        if (a == b) {
            return a;
        }
        return a * fact(a-1, b, MOD) % MOD;
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
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