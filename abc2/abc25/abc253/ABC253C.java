import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC253C {

    public static void main(String[] args) {
        int q = nextInt();
        TreeMap<Integer, Integer> s = new TreeMap<>();
        while (q --> 0) {
            int t = nextInt();
            if (t == 1) {
                int x = nextInt();
                s.put(x, s.getOrDefault(x, 0)+1);
            } else if (t == 2) {
                int x = nextInt();
                int c = nextInt();
                Integer count = s.getOrDefault(x, 0);
                s.put(x, Math.max(0, count-c));
                s.remove(x, 0);
            } else {
                out.println(s.lastKey() - s.firstKey());
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