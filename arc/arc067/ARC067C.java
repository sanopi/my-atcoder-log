import java.io.PrintWriter;
import java.util.Scanner;

public class ARC067C {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int[] primes = new int[n+1];

        for (int i = 2; i <= n; i++) {
            int x = i;
            for (int j = 2; j < x; j++) {
                while (x%j==0) {
                    primes[j]++;
                    x/=j;
                }
            }
            if (x>1) {
                primes[x]++;
            }
        }
        long ans = 1;
        for (int i = 0; i < n+1; i++) {
            ans *= (primes[i]+1);
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