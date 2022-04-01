import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC241D {

    public static void main(String[] args) {
        int q = nextInt();
        TreeMap<Long, Integer> counter = new TreeMap<>();
        while (q-->0) {
            int c = nextInt();
            long x = nextLong();
            if (c == 1) {
                counter.put(x, counter.getOrDefault(x, 0)+1);
            } else if (c == 2) {
                int k = nextInt();
                x++;
                while (k>0) {
                    Map.Entry<Long, Integer> entry = counter.lowerEntry(x);
                    if (entry == null) {
                        x = -1;
                        break;
                    }
                    x = entry.getKey();
                    k -= entry.getValue();
                }
                out.println(x);
            } else {
                int k = nextInt();
                x--;
                while (k>0) {
                    Map.Entry<Long, Integer> entry = counter.higherEntry(x);
                    if (entry == null) {
                        x = -1;
                        break;
                    }
                    x = entry.getKey();
                    k -= entry.getValue();
                }
                out.println(x);
            }
        }

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