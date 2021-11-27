import java.io.PrintWriter;
import java.util.Scanner;

public class ABC197D {

    public static void main(String[] args) {
        int n = nextInt();
        int x0 = nextInt();
        int y0 = nextInt();
        int xn2 = nextInt();
        int yn2 = nextInt();

        int xDiff = xn2 - x0;
        int yDiff = yn2 - y0;

        double centerLen = Math.sqrt(xDiff * xDiff + yDiff * yDiff);
        double edgeLen = centerLen * Math.sin(Math.toRadians(180.0 / n));

        double angle = Math.toRadians(90.0*(n-2) /n);
        double angle1 = Math.atan2(yDiff, xDiff) - angle;
        out.println((Math.cos(angle1)*edgeLen+x0) + " " + (Math.sin(angle1)*edgeLen+y0));
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