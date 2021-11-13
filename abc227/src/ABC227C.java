import java.io.PrintWriter;
import java.util.Scanner;

public class ABC227C {

    public static void main(String[] args) {
        long n = nextLong();
        long count=0;
        for (long a = 1; a*a <= n; a++) {
            for (long b = a; b <= n / (a * b); b++) {
                long sho = n / (a * b);
                if (sho >= b) {
                    count += (sho-b+1);
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