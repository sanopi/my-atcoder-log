import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q36_MaxManhattanDistance_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        Pair[] prot = new Pair[n];
        // 45度回転 & √2倍 済みのものを取っておく。
        for (int i = 0; i < n; i++) {
            long x = nextLong();
            long y = nextLong();
            prot[i] = new Pair(x-y, x+y);
        }

        Pair xmax = Arrays.stream(prot).max(Comparator.comparing(p -> p.x)).get();
        Pair xmin = Arrays.stream(prot).min(Comparator.comparing(p -> p.x)).get();
        Pair ymax = Arrays.stream(prot).max(Comparator.comparing(p -> p.y)).get();
        Pair ymin = Arrays.stream(prot).min(Comparator.comparing(p -> p.y)).get();

        for (int i = 0; i < q; i++) {
            Pair base = prot[nextInt()-1];
            long xx = Math.abs(base.x - xmax.x);
            long xxx = Math.abs(base.x - xmin.x);
            long yy = Math.abs(base.y - ymax.y);
            long yyy = Math.abs(base.y - ymin.y);

            out.println(Math.max(xx, Math.max(xxx, Math.max(yy, yyy))));
        }

        out.flush();
    }

    private static class Pair {
        long x;
        long y;
        public Pair(final long x, final long y) {
            this.x = x;
            this.y = y;
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