import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC230D {

    public static void main(String[] args) {
        int n = nextInt();
        int d = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            int r = nextInt();
            pairs[i] = new Pair(l, r);
        }
        Arrays.sort(pairs, Comparator.comparing(p -> p.r));
        int i = 0;
        int p = 0;
        int count = 0;
        while (i < n) {
            Pair current = pairs[i];
            if (current.l > p) {
                p = current.r + d-1;
                count++;
            }
            i++;
        }

        out.println(count);
        out.flush();
    }

    private static class Pair {
        int l;
        int r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
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