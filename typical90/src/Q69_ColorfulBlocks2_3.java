import java.io.PrintWriter;
import java.util.Scanner;

public class Q69_ColorfulBlocks2_3 {

    static int mod = 1000000007;

    public static void main(String[] args) {
        long n = nextLong();
        long k = nextLong();

        if (n == 1) {
            out.println(k);
        } else if (n == 2) {
            if (k == 1) {
                out.println(0);
            } else {
                out.println((k * (k -1)) % mod);
            }
        } else {
            if (k <= 2) {
                out.println(0);
            } else {
                out.println(((k * (k-1)) % mod * modPow(k-2, n-2, mod)) % mod);
            }
        }
        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a;
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}