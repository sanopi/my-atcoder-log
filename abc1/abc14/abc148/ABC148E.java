import java.io.PrintWriter;
import java.util.Scanner;

public class ABC148E {

    public static void main(String[] args) {
        long n = nextLong();
        if (n%2==1) {
            out.println(0);
        } else {
            n = n/2;
            long ans = 0;
            while (n >= 5) {
                ans += (n = n/5);
            }
            out.println(ans);
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