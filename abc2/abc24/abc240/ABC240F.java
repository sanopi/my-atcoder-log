import java.io.PrintWriter;
import java.util.Scanner;

public class ABC240F {

    public static void main(String[] args) {
        int t = nextInt();
        while (t-->0) {
            int n = nextInt();
            int m = nextInt();
            int[] X = new int[n];
            int[] Y = new int[n];
            for (int i = 0; i < n; i++) {
                X[i] = nextInt();
                Y[i] = nextInt();
            }

            long ans = X[0];
            long a = 0;
            long b = 0;
            for (int i = 0; i < n; i++) {
                long y = Y[i];
                long x = X[i];

                if (x<0 && b>0) {
                    long point = b / -x;
                    if (point < y) {
                        ans = Math.max(ans, a + b*point + x*point*(point+1)/2);
                    }
                }

                a += b*y + x*y*(y+1)/2;
                b += x*y;
                ans = Math.max(a, ans);
            }
            out.println(ans);
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