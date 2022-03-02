import java.io.PrintWriter;
import java.util.Scanner;

public class Tenka1_2017C {

    public static void main(String[] args) {
        long N = nextLong();

        for (int i = 1; i <= 3500; i++) {
            for (int j = 1; j <= 3500; j++) {
                long bunbo = N * i * j;
                long bunshi = 4 * i * j - N * i - N * j;
                if (bunshi==0 || bunshi<0) continue;
                if (bunbo % bunshi == 0) {
                    System.out.println(i+" "+j+" "+(bunbo/bunshi));
                    return;

                }
            }
        }
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