import java.io.PrintWriter;
import java.util.Scanner;

public class ABC267A {

    public static void main(String[] args) {
        String s = next();
        if(s.equals("Monday")) {
            out.println(5);
        } if(s.equals("Tuesday")) {
            out.println(4);
        } if(s.equals("Wednesday")) {
            out.println(3);
        } if(s.equals("Thursday")) {
            out.println(2);
        } if(s.equals("Friday")) {
            out.println(1);
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