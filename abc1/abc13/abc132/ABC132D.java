import java.io.PrintWriter;
import java.util.Scanner;

public class ABC132D {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
//        solve1(n, k);
        solve2(n, k);
        out.flush();
    }
    private static void solve2(int n, int k) {
        int r = n-k;
        for (int i = 0; i < k; i++) {
            long blue = i>0&&k-1>i?modCombination(k-1, i, MOD):1;
            long red = r+1>i+1?modCombination(r+1, i+1, MOD):r+1==i+1?1:0;
            out.println(blue*red%MOD);
        }
    }

    private static void solve1(int n, int k) {
        int r = n - k;
        long c = 1;
        long rc = r+1;
        out.println(c*Math.max(0, rc));
        for (int i = 1; i < k; i++) {
            c*=(k -1-i+1);
            c%=MOD;
            c*=modInv(i);
            c%=MOD;

            rc*=Math.max(0, r+1-i);
            rc%=MOD;
            rc*=modInv(i+1);
            rc%=MOD;
            out.println(c*rc%MOD);
        }
    }

    private static long memo[] = new long[2001];

    private static long modInv(int a) {
        if (memo[a]>0) {
            return memo[a];
        }
        long result = modPow(a, MOD - 2, MOD);
        return memo[a]=result;
    }

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