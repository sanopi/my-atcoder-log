import java.io.PrintWriter;
import java.util.Scanner;

public class AGC018A {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);
        int gcd = a[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, a[i]);
        }
        for (int i = 0; i < n; i++) {
            if (a[i]-k<0) continue;
            if ((a[i]-k)%gcd==0) {
                System.out.println("POSSIBLE");
                return;
            }
        }
        out.println("IMPOSSIBLE");
        out.flush();
    }

    private static int gcd(int a, int b) {
        if (a%b==0) {
            return b;
        }
        return gcd(b, a%b);
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