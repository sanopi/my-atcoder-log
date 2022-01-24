import java.io.PrintWriter;
import java.util.Scanner;

public class ABC236C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        String[] s = new String[n];
        String[] t = new String[m];
        for (int i = 0; i < n; i++) {
            s[i] = next();
        }
        for (int i = 0; i < m; i++) {
            t[i] = next();
        }
        int ti = 0;
        for (int i = 0; i < n; i++) {
            if (s[i].equals(t[ti])) {
                out.println("Yes");
                ti++;
            } else {
                out.println("No");
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