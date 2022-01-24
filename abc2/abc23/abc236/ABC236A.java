import java.io.PrintWriter;
import java.util.Scanner;

public class ABC236A {

    public static void main(String[] args) {
        String s = next();
        int a = nextInt();
        int b = nextInt();
        System.out.println(s.substring(0,a-1)+s.charAt(b-1)+s.substring(a, b-1)+s.charAt(a-1)+s.substring(b));
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