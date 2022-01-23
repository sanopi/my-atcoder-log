import java.io.PrintWriter;
import java.util.Scanner;

public class ABC236B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] count = new int[n+1];
        for (int i = 0; i < 4 * n - 1; i++) {
            count[nextInt()]++;
        }
        for (int i = 0; i < n + 1; i++) {
            if (count[i]==3) {
                System.out.println(i);
                return;
            }
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