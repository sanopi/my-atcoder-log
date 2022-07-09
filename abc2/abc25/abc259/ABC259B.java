import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

public class ABC259B {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int d = nextInt();
        DoubleBiVector result = new DoubleBiVector(a, b).rotate(d);
        out.println(result.x + " " + result.y);

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

    static class DoubleBiVector {
        double x;
        double y;
        private DoubleBiVector(final double x, final double y) {
            this.x = x;
            this.y = y;
        }
        private DoubleBiVector add(DoubleBiVector other) {
            return new DoubleBiVector(this.x+other.x, this.y+other.y);
        }
        private DoubleBiVector minus(DoubleBiVector other) {
            return new DoubleBiVector(this.x-other.x, this.y-other.y);
        }
        private DoubleBiVector rotate(double degree) {
            double radians = Math.toRadians(degree);
            double newX = Math.cos(radians)*x - Math.sin(radians)*y;
            double newY = Math.sin(radians)*x + Math.cos(radians)*y;
            return new DoubleBiVector(newX, newY);
        }
        private DoubleBiVector rotate(double degree, DoubleBiVector base) {
            return this.minus(base).rotate(degree).add(base);
        }
        @Override
        public String toString() {
            return String.format("{x=%s, y=%s}", x, y);
        }
        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final DoubleBiVector that = (DoubleBiVector) o;
            return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}