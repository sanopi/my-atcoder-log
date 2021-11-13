import java.io.PrintWriter;
import java.util.Scanner;

public class ABC227B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] s = nextIntArray(n);
        int count=0;
        for (int i = 0; i < n; i++) {
            boolean ok = false;
            for (int a = 1; a < 1000; a++) {
                for (int b = 1; b < 1000; b++) {
                    int ss = 4*a*b + 3*a + 3*b;
                    if (ss > 1000) {
                        break;
                    }
                    if (s[i] == ss) {
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            if (!ok) count++;
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