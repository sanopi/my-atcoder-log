import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC197E {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        Arrays.fill(pairs, Pair.UNIT);
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int c = nextInt()-1;
            pairs[c] = pairs[c].change(x);
        }
        Result result = new Result(new Point(0, 0), new Point(0, 0));
        for (int i = 0; i < n; i++) {
            Pair pair = pairs[i];
            if (!pair.equals(Pair.UNIT)) {
                result = result.next(pair);
            }
        }
        result = result.next(new Pair(0, 0));
        out.println(Math.min(result.left.total, result.right.total));
        out.flush();
    }

    private static class Result {
        Point left;
        Point right;
        public Result(Point left, Point right) {
            this.left = left;
            this.right = right;
        }
        private Result next(Pair pair) {
            return new Result(
                new Point(
                    pair.min,
                    Math.min(pair.diff()+Math.abs(pair.max-right.x)+ right.total, pair.diff()+Math.abs(pair.max-left.x)+ left.total)
                    ),
                new Point(
                    pair.max,
                    Math.min(pair.diff()+Math.abs(pair.min-right.x)+ right.total, pair.diff()+Math.abs(pair.min-left.x)+ left.total)
                )
            );
        }
    }

    private static class Point {
        long x;
        long total;
        public Point(long x, long total) {
            this.x = x;
            this.total = total;
        }
    }

    private static class Pair {
        private static final Pair UNIT = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        final long min;
        final long max;
        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
        private Pair change(long x) {
            return new Pair(Math.min(this.min, x), Math.max(this.max, x));
        }
        private long diff() {
            return max-min;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (min != pair.min) return false;
            return max == pair.max;
        }
        @Override
        public int hashCode() {
            int result = (int) (min ^ (min >>> 32));
            result = 31 * result + (int) (max ^ (max >>> 32));
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