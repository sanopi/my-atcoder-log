package again;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q36_MaxManhattanDistance {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        int[] rotatedX = new int[n];
        int[] rotatedY = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            rotatedX[i] = x-y;
            rotatedY[i] = x+y;
        }
        long xMin = Arrays.stream(rotatedX).min().getAsInt();
        long xMax = Arrays.stream(rotatedX).max().getAsInt();
        long yMin = Arrays.stream(rotatedY).min().getAsInt();
        long yMax = Arrays.stream(rotatedY).max().getAsInt();

        while (q-->0) {
            int i = nextInt()-1;
            int x = rotatedX[i];
            int y = rotatedY[i];
            out.println(
                Math.max(
                    Math.max(Math.abs(xMin-x), Math.abs(xMax-x)),
                    Math.max(Math.abs(yMax-y),  Math.abs(yMin-y))
                )
            );
        }
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