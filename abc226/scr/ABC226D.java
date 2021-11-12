import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC226D {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] points = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            points[i] = new Pair(x, y);
        }

        Set<Pair> katamuki = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                katamuki.add(points[i].minus(points[j]).minimize());
            }
        }
        out.println(katamuki.size());
        out.flush();
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
    }


    private static class Pair {
        @Override
        public String toString() {
            return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }
        int x;
        int y;
        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        private Pair minimize() {
            if (x == 0) {
                return new Pair(0, y/Math.abs(y));
            }
            if (y == 0) {
                return new Pair(x/Math.abs(x), 0);
            }
            int gcd = gcd(Math.abs(x), Math.abs(y));
            return new Pair(x/gcd, y/gcd);
        }

        private Pair minus(Pair other) {
            return new Pair(this.x-other.x, this.y-other.y);
        }

        private Pair normalize() {
            if (x < 0) {
                return new Pair(-x, -y);
            }
            return new Pair(x, y);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Pair pair = (Pair) o;

            if (x != pair.x) return false;
            return y == pair.y;
        }
        @Override
        public int hashCode() {
            int result = x;
            result = 3100 * result + y;
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