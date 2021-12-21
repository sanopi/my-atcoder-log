import java.io.PrintWriter;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

public class ABC197D {

    private static double n;
    private static double x0;
    private static double y0;
    private static double xn2;
    private static double yn2;
    public static void main(String[] args) {
        n = nextInt();
        x0 = nextDouble();
        y0 = nextDouble();
        xn2 = nextDouble();
        yn2 = nextDouble();
//        solve1();
//        solve2();
        solve3();
    }

    private static void solve3() {
        var zero = new DoubleBiVector(x0, y0);
        var center = new DoubleBiVector((xn2 + x0)/2, (yn2 + y0)/2);
        var ans = zero.rotate(360.0/n, center);
        System.out.println(ans.x + " " + ans.y);
    }

    private static void solve2() {
        double xo = (xn2 + x0)/2;
        double yo = (yn2 + y0)/2;

        // 回転
        double angle = toRadians(360.0 / n);
        double ansx = xo + (cos(angle)*(x0-xo)-sin(angle)*(y0-yo));
        double ansy = yo + (sin(angle)*(x0-xo)+cos(angle)*(y0-yo));
        System.out.println(ansx + " " + ansy);
    }

    private static void solve1() {
        double xDiff = xn2 - x0;
        double yDiff = yn2 - y0;

        double centerLen = sqrt(xDiff * xDiff + yDiff * yDiff);
        double edgeLen = centerLen * sin(toRadians(180.0 / n));

        double angle = toRadians(90.0*(n -2) / n);
        double angle1 = atan2(yDiff, xDiff) - angle;
        out.println((cos(angle1)*edgeLen+ x0) + " " + (sin(angle1)*edgeLen+ y0));
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


    private static class DoubleBiVector {
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