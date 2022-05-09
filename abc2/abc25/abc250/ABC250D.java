import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC250D {

    public static void main(String[] args) {
        long n = nextLong();

        boolean[] primes = new boolean[1000001];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < 1000001; i++) {
            for (int j = i*2; j < 1000001; j+=i) {
                if (!primes[j]) continue;
                primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i>=0 && (long)i*i*i*i <= n; i++) {
            if (!primes[i]) continue;
            long m = n/i;
            for (int j = i+1; (long)j*j*j <= m; j++) {
                if (!primes[j]) continue;
                count++;
            }
        }
        out.println(count);
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