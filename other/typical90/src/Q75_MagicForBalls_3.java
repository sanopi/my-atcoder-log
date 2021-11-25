import java.io.PrintWriter;
import java.util.Scanner;

public class Q75_MagicForBalls_3 {

    public static void main(String[] args) {
        long n = nextLong();
        long k = n;
        int count = 0;
        for (long i = 2; i*i <= n;) {
            if (k % i == 0) {
                count++;
                k /= i;
                continue;
            }
            i++;
        }
        if (k != 1) {
            count++;
        }
        int i = 0;
        while (true) {
            int exp = 1 << i;
            if (exp >= count) {
                break;
            }
            i++;
        }
        out.println(i);
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}