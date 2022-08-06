import java.io.PrintWriter;
import java.util.Scanner;

public class ABC263B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] p = new int[n];
        for (int i = 1; i < n; i++) {
            p[i] = nextInt()-1;
        }

        int i = n-1;
        int ans = 0;
        while (i!=0) {
            ans++;
            i = p[i];
        }
        out.println(ans);
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