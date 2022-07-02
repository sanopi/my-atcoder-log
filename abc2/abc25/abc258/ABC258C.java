import java.io.PrintWriter;
import java.util.Scanner;

public class ABC258C {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        String s = next();
        int point = 0;
        while (q-- > 0) {
            int t = nextInt();
            int x = nextInt();
            if (t == 1) {
                point += x;
                point %= n;
            } else {
                x-=1;
                out.println(s.charAt((x-point+2*n)%n));
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