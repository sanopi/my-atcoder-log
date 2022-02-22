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
            long n = k + l;
            out.println(modCombination(n, k, MOD));
        }
        out.flush();
    }

    /**
     * n*(n-1)*...*(n-k+1)
     * を
     * (n-k)!で割る
     */
    private static long modCombination(long n, long k, int mod) {
        long numerator = modFact(n, n-k, mod);
        long denominator = modFact(k, 1, mod);
        long invDenominator = modPow(denominator, mod - 2, mod);

        return numerator * invDenominator % mod;
    }

    private static long modFact(long from, long toEx, int mod) {
        if (from == toEx) {
            return 1;
        }
        return from * modFact(from-1, toEx, mod) % mod;
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