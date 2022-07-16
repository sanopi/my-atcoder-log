import java.io.PrintWriter;
import java.util.Scanner;

public class ARC144A {

    public static void main(String[] args) {
        int n = nextInt();
        out.println(2*n);

        int count = n / 4;
        int rest = n % 4;
        if (rest == 0) {
            out.println("4".repeat(count));
        } else {
            out.println(rest + "4".repeat(count));
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