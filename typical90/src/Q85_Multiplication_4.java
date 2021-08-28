import java.io.PrintWriter;
import java.util.Scanner;

public class Q85_Multiplication_4 {

    public static void main(String[] args) {
        long k = nextLong();

        int count = 0;
        for (int i = 1; (long) i*i*i <=k ; i++) {
            if (k % i == 0) {
                long kk = k/i;
                for (int j = i; (long) j*j <= kk; j++) {
                    if (kk % j == 0) {
                        count++;
                    }
                }
            }
        }

        out.println(count);
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