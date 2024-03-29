import java.io.PrintWriter;
import java.util.Scanner;

public class CADDI2018D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i]%2;
        }
        out.println(sum!=0?"first":"second");
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