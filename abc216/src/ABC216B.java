import java.io.PrintWriter;
import java.util.Scanner;

public class ABC216B {

    public static void main(String[] args) {
        int n = nextInt();
        String[] s = new String[n];
        String[] t = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
            t[i] = next();
        }

        boolean ok = false;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (s[i].equals(s[j]) && t[i].equals(t[j])) {
                    ok = true;
                    break;
                }
            }
        }

        out.println(ok ? "Yes" : "No");

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