import java.io.PrintWriter;
import java.util.Scanner;

public class ABC225B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            t[a] += 1;
            t[b] += 1;
        }
        int one = 0;
        int enu = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == 1) {
                one++;
            } else if (t[i] == n-1) {
                enu++;
            }
        }
        out.println((one == n-1 && enu == 1) ? "Yes" : "No");

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