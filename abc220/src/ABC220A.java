import java.io.PrintWriter;
import java.util.Scanner;

public class ABC220A {

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        for (int i = a; i <= b; i++) {
            if (i % c == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
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