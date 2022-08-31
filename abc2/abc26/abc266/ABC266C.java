import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC266C {

    public static void main(String[] args) {
        Point[] points = new Point[4];
        for (int i = 0; i < 4; i++) {
            points[i] = new Point(nextInt(), nextInt());
        }
        List<Boolean> bools = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Point pi = points[i];
            Point pi1 = points[(i+1)%4];
            int xdiff1 = pi1.x-pi.x;
            int ydiff1 = pi1.y-pi.y;

            Point pi2 = points[(i+2)%4];
            int xdiff2 = pi2.x-pi.x;
            int ydiff2 = pi2.y-pi.y;

            bools.add(counterClockWise(xdiff1, ydiff1, xdiff2, ydiff2));
        }
        boolean ok = bools.stream().distinct().count() == 1;
        out.println(ok?"Yes":"No");
        out.flush();
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean counterClockWise(int x1, int y1, int x2, int y2) {
        return x1*y2-y1*x2 > 0;
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