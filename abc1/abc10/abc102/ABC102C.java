import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ABC102C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        while (Math.abs(min-max)>2) {
            long point1 = (min+min+max)/3;
            long point2 = (min+max+max)/3;
            if (calc(point1, a) <= calc(point2, a)) {
                max = point2;
            } else {
                min = point1;
            }
        }
        out.println(LongStream.range(min, max+1).map(l -> calc(l, a)).min().getAsLong());
        out.flush();
    }

    private static long calc(long b, int[] array) {
        long res = 0;
        for (int i = 0; i < array.length; i++) {
            res += Math.abs((b+i+1)-array[i]);
        }
        return res;
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