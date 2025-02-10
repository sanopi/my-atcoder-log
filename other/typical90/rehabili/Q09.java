import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Q09 {

    private static void solve() {
        int n = nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(nextInt(), nextInt());
        }

        double ans = 0;
        for (int j = 0; j < n; j++) {
            Point pj = points[j];
            double[] angles = new double[n-1];

            for (int i = 0; i < n; i++) {
                if (i == j) continue;
                angles[i + (i < j ? 0 : -1)] = pj.getDiff(points[i]).angle;
            }

            Arrays.sort(angles);

            for (double angle : angles) {
                double degrees = (angle + 180) % 360;
                int found = upperBound(angles, degrees);


                double more = angles[found%angles.length];
                double less = angles[(found-1+angles.length)%angles.length];

                ans = Math.max(
                        ans,
                        Math.max(calcAngle(angle, more), calcAngle(angle, less))
                );

            }
        }
        out.println(ans);
        out.flush();
    }

    private static double calcAngle(double a, double b) {
        double diff = Math.abs(a-b);
        return Math.min(diff, 360-diff);
    }

    private static int upperBound(double[] a, double key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }

    private static class Point {
        long x;
        long y;
        double angle;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
            this.angle = Math.toDegrees(Math.atan2(x, y));
        }

        Point getDiff(Point other) {
            return new Point(other.x - this.x, other.y - this.y);
        }
        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", angle=" + angle +
                    '}';
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && Double.compare(angle, point.angle) == 0;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y, angle);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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