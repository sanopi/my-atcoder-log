import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC255E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long[] s = nextLongArray(n-1);
        long[] x = nextLongArray(m);

        long[] a = new long[n];
        a[0] = 0;
        for (int i = 1; i < n; i++) {
            a[i] = s[i-1]-a[i-1];
        }

        Map<Long, Integer> counts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            for (int j = 0; j < m; j++) {
                long xj = x[j];
                long diff = (i%2==0?1:-1) * (ai-xj);
                counts.put(diff, counts.getOrDefault(diff, 0)+1);
            }
        }
        out.println(counts.values().stream().mapToLong(l -> l).max().getAsLong());
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