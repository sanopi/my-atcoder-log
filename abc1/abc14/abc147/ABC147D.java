import java.io.PrintWriter;
import java.util.Scanner;

public class ABC147D {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        int[] bitCount = new int[60];
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            for (int j = 0; j < 60; j++) {
                bitCount[j]+=ai%2;
                ai/=2;
            }
        }
        long ans = 0;
        for (int i = 0; i < 60; i++) {
            ans += (1L <<i)%MOD * ((long) bitCount[i] *(n-bitCount[i]) % MOD);
            ans%=MOD;
        }
        out.println(ans);
        out.flush();
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