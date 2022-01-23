import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CADDI2018A {

    public static void main(String[] args) {
        long n = nextLong();
        long p = nextLong();
        Map<Long, Integer> counts = new HashMap<>();
        for (long i = 2; i*i <= p; i++) {
            while (p%i==0) {
                p/=i;
                counts.put(i, counts.getOrDefault(i, 0)+1);
            }
        }
        counts.put(p, counts.getOrDefault(p, 0)+1);

        System.out.println(counts.entrySet()
            .stream()
            .filter(entry -> entry.getValue() / n > 0)
            .map(entry -> exp(entry.getKey(), entry.getValue()/n))
            .reduce(1L, Math::multiplyExact)
        );
        out.flush();
    }

    private static long exp(long a, long b) {
        long res = 1;
        while (b>0) {
            res *= a;
            b--;
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