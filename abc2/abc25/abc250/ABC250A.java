import java.io.PrintWriter;
import java.util.Scanner;

public class ABC250A {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int r = nextInt();
        int c = nextInt();

        out.println((h==1?0:1) + (w==1?0:1) + (r==1||r==h?0:1) + (c==1||c==w?0:1));
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