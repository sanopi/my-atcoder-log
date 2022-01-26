import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC127D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            counts.put(a[i], counts.getOrDefault(a[i], 0)+1);
        }
        for (int i = 0; i < m; i++) {
            int b = nextInt();
            int c = nextInt();
            while (b>0) {

                Map.Entry<Integer, Integer> first = counts.firstEntry();
                if (first.getKey() >= c) {
                    break;
                }
                int newCount = Math.min(first.getValue(), b);
                counts.put(c, counts.getOrDefault(c, 0)+newCount);
                if (first.getValue() - newCount > 0) {
                    counts.put(first.getKey(), first.getValue() - newCount);
                } else {
                    counts.remove(first.getKey());
                }
                b-=newCount;

            }
        }

        out.println(counts.entrySet().stream().mapToLong(entry -> (long) entry.getKey() *entry.getValue()).sum());
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