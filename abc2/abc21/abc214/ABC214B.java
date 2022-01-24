import java.io.PrintWriter;
import java.util.Scanner;

public class ABC214B {

    public static void main(String[] args) {
        int s = nextInt();
        int t = nextInt();
        int count = 0;
        for (int a = 0; a <= 100; a++) {
            for (int b = 0; b <= 100-a; b++) {
                for (int c = 0; c <= 100-a-b; c++) {
                    if (a + b + c <= s && a * b * c <= t) {
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