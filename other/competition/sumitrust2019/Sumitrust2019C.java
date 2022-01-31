import java.io.PrintWriter;
import java.util.Scanner;

public class Sumitrust2019C {

    public static void main(String[] args) {
        int x = nextInt();
        int count = 0;
        int sub = x % 100;
        for (int i = 5 ; i >= 1; i--) {
            count += sub/i;
            sub %= i;
        }
        if (count > x/100) {
            System.out.println(0);
        } else {
            System.out.println(1);
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