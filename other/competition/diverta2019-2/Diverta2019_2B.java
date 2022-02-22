import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Diverta2019_2B {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }
        Arrays.sort(pairs, Comparator.comparing((Pair p) -> p.x).thenComparing(p -> p.y));
        Map<Pair, Integer> diffCounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                Pair pi = pairs[i];
                Pair pj = pairs[j];
                Pair diff = new Pair(pj.x - pi.x, pj.y - pi.y);
                diffCounts.put(diff, diffCounts.getOrDefault(diff, 0)+1);
            }
        }
        out.println(n - diffCounts.values().stream().max(Comparator.naturalOrder()).orElse(0));
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
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