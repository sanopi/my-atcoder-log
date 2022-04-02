import java.io.PrintWriter;
import java.util.Scanner;

public class ABC246D {

    public static void main(String[] args) {
        long n = nextLong();

        int k = 0;
        while (true) {
            long k3 = (long) k*k*k;
            if (k3>=n) {
                break;
            }
            k++;
        }
        long ans = calc(k, 0);
        int a = k-1;
        int b = 1;
        while (a>=b) {
            while (true) {
                long res = calc(a, b);
                if (res >= n) {
                    ans = Math.min(ans, res);
                    break;
                }
                if (res < 0) break;
                b++;
            }
            a--;
        }

        out.println(ans);
        out.flush();
    }

    private static long calc(long a, long b) {
        return a*a*a + a*a*b + a*b*b + b*b*b;
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