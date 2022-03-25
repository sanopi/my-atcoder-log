import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC233D {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        int[] a = nextIntArray(n);

        long[] sums = new long[n+1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + a[i];
        }

        Map<Long, Integer> count = new HashMap<>();
        long ans = 0;
        for (int i = 0; i <= n; i++) {
            long sum = sums[i];
            ans += count.getOrDefault(sum-k, 0);

            count.put(sum, count.getOrDefault(sum, 0)+1);
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