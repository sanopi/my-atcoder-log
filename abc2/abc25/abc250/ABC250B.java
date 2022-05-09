import java.io.PrintWriter;
import java.util.Scanner;

public class ABC250B {

    public static void main(String[] args) {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();

        for (int i = 0; i < a * n; i++) {
            for (int j = 0; j < b * n; j++) {
                if ((i/a)%2==0 ^ (j/b)%2==0) {
                    out.print("#");
                } else {
                    out.print(".");
                }
            }
            out.println();
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