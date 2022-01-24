import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ABC235C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] a = nextIntArray(n);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = map.getOrDefault(a[i], new ArrayList<>());
            l.add(i+1);
            map.put(a[i], l);
        }

        for (int i = 0; i < q; i++) {
            int x = nextInt();
            int k = nextInt();
            List<Integer> l = map.get(x);
            if (l == null || l.size() < k) {
                out.println(-1);
                continue;
            }
            out.println(l.get(k-1));
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