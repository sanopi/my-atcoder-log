import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Nikkei2019_2_QualB {

    private static int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] d = nextIntArray(n);
        if (d[0] != 0) {
            System.out.println(0);
            return;
        }
        int dMax = Arrays.stream(d).max().getAsInt();
        int[] counts = new int[dMax+1];
        for (int i = 0; i <= n-1; i++) {
            counts[d[i]]++;
        }
        if (counts[0] > 1) {
            System.out.println(0);
            return;
        }
        if (dMax==1) {
            System.out.println(1);
            return;
        }
        long ans = 1;

        for (int i = 1; i <= dMax; i++) {
            ans *= modPow(counts[i-1], counts[i], MOD);
            ans %= MOD;
        }
        System.out.println(ans);
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