import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;

public class ABC197D {

    public static void main(String[] args) {
//        solve1();
        solve2();
    }

    private static void solve2() {
        int n = nextInt();
        double x0 = nextDouble();
        double y0 = nextDouble();
        double xn2 = nextDouble();
        double yn2 = nextDouble();
        double xo = (xn2 + x0)/2;
        double yo = (yn2 + y0)/2;

        // 回転
        double angle = toRadians(360.0 / n);
        double ansx = xo + (cos(angle)*(x0-xo)-sin(angle)*(y0-yo));
        double ansy = yo + (sin(angle)*(x0-xo)+cos(angle)*(y0-yo));
        System.out.println(ansx + " " + ansy);
    }

    private static void solve1() {
        int n = nextInt();
        int x0 = nextInt();
        int y0 = nextInt();
        int xn2 = nextInt();
        int yn2 = nextInt();

        int xDiff = xn2 - x0;
        int yDiff = yn2 - y0;

        double centerLen = sqrt(xDiff * xDiff + yDiff * yDiff);
        double edgeLen = centerLen * sin(toRadians(180.0 / n));

        double angle = toRadians(90.0*(n-2) /n);
        double angle1 = atan2(yDiff, xDiff) - angle;
        out.println((cos(angle1)*edgeLen+x0) + " " + (sin(angle1)*edgeLen+y0));
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

}