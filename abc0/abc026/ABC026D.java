import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Function;

public class ABC026D {

    public static void main(String[] args) {
        double a = nextDouble();
        double b = nextDouble();
        double c = nextDouble();

        Function<Double, Double> f = t -> a*t+b*Math.sin(c*t*Math.PI);


        double upper = 1000;
        double lower = 0;
        while (Math.abs(f.apply(lower)-100) > 0.000001) {
            double mid = (upper+lower)/2;
            if (f.apply(mid) < 100) {
                lower = mid;
            } else {
                upper = mid;
            }
        }
        out.println(lower);
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