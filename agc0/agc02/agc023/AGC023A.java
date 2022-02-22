import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AGC023A {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        long[] sum = new long[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i-1]+a[i-1];
        }

        Map<Long, Long> counts = new HashMap<>();
        for (long l : sum) {
            counts.put(l, counts.getOrDefault(l, 0L)+1);
        }
        out.println(counts.values().stream().reduce(0L, (i, j) -> i + comb(j, 2)));
        out.flush();
    }

    private static long comb(long n, long k) {
        if (k>n) {
            return 0;
        }
        return fact(n, n-k) / fact(k, 1);
    }

    private static long fact(long a, long b) {
        if (a == b) {
            return 1;
        }
        return a * fact(a-1, b);
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