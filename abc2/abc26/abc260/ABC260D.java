import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC260D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            int p = nextInt();
            Pair pair = new Pair(i, p);
            Map.Entry<Integer, List<Pair>> found = map.higherEntry(p);
            List<Pair> value;
            if (found == null) {
                value = new ArrayList<>();
            } else {
                map.remove(found.getKey());
                value = found.getValue();
            }
            value.add(pair);
            if (value.size() == k) {
                for (Pair pp : value) {
                    ans[pp.p-1] = i+1;
                }
                continue;
            }
            map.put(p, value);
        }

        for (int an : ans) {
            out.println(an);
        }

        out.flush();
    }

    private static final class Pair {
        int i;
        int p;
        public Pair(int i, int p) {
            this.i = i;
            this.p = p;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "i=" + i +
                ", p=" + p +
                '}';
        }
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