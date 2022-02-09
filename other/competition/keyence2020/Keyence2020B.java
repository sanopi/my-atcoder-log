import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Keyence2020B {

    public static void main(String[] args) {
        int n = nextInt();
        Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int arm = nextInt();
            ranges[i] = new Range(x-arm, x+arm);
        }
        Arrays.sort(ranges, Comparator.comparing(range -> range.r));

        int point = Integer.MIN_VALUE;
        int count = 0;
        for (Range range : ranges) {
            if (range.l >= point) {
                point = range.r;
                count++;
            }
        }
        out.println(count);
        out.flush();
    }

    private static class Range {
        int l;
        int r;
        public Range(int l, int r) {
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