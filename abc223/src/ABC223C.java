import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC223C {

    public static void main(String[] args) {
        int n = nextInt();
        double[] a = new double[n];
        double[] b = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextDouble();
            b[i] = nextDouble();
        }

        double[] as = new double[n];
        for (int i = 0; i < n; i++) {
            as[i] = a[i] / b[i];
        }

        double sum = Arrays.stream(as).sum(); // 秒

        double ans = 0; // cm
        double ansS = 0; // 秒
        int i = 0;
        while (i < n) {
            if (ansS + as[i] > (sum/2)) {
                break;
            }
            ans += a[i];
            ansS += as[i];
            i++;
        }
        ans += ((sum/2 - ansS) * b[i]);
        out.println(ans);
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
    static double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) { array[i] = nextDouble(); }
        return array;
    }

}