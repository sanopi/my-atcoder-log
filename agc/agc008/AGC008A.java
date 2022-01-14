import java.io.PrintWriter;
import java.util.Scanner;

public class AGC008A {

    public static void main(String[] args) {
        long x = nextInt();
        long y = nextInt();
        long ans = 0;
        long absDiff = getAbsDiff(x, y);
        if (absDiff==0) {
            System.out.println(1);
            return;
        }
        if (getAbsDiff(x+1, y) < absDiff) {
            ans += absDiff;
            x+=absDiff;
        } else {
            ans += absDiff+1;
            x=-x;
            x+=absDiff;
        }
        out.println(x * y >= 0 ? ans : ans + 1);

        out.flush();
    }

    private static long getAbsDiff(long x, long y) {
        return Math.abs(Math.abs(x) - Math.abs(y));
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