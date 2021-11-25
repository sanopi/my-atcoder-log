import java.io.PrintWriter;
import java.util.Scanner;

public class ABC216A {

    public static void main(String[] args) {
        String xy = next();
        String x = xy.substring(0, xy.indexOf("."));
        String y = xy.substring(xy.indexOf(".")+1, xy.length());
        int yy = Integer.parseInt(y);

        String suf;
        if (0 <= yy && yy <= 2) {
            suf = "-";
        } else if (3 <= yy && yy <= 6) {
            suf = "";
        } else {
            suf = "+";
        }
        out.println(x+suf);
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