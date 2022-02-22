import java.io.PrintWriter;
import java.util.Scanner;

public class ABC156D {

    private static int MOD = 1000000007;

    public static void main(String[] args) throws InterruptedException {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();

        long ans = modPow(2, n, MOD) - 1;
        ans -= fact(n, n - a + 1, MOD) * modPow(fact(a, 1, MOD), MOD - 2, MOD);
        ans %= MOD;
        ans += MOD;
        ans %= MOD;
        ans -= fact(n, n - b + 1, MOD) * modPow(fact(b, 1, MOD), MOD - 2, MOD);
        ans %= MOD;
        ans += MOD;
        ans %= MOD;
        out.println(ans);
        out.flush();
    }

    private static long fact(long a, long b, int mod) {
        if (a == b) {
            return a;
        }
        return a * fact(a-1, b, mod) % mod;
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