import java.io.PrintWriter;
import java.util.Scanner;

public class ABC050C {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] counts = new int[n];
        for (int i : a) {
            counts[i]++;
        }
        if (n%2==0) {
            for (int i = 1; i < n; i+=2) {
                if (counts[i]!=2) {
                    System.out.println(0);
                    return;
                }
            }
        } else {
            if (counts[0]!=1) {
                System.out.println(0);
                return;
            }
            for (int i = 2; i < n; i+=2) {
                if (counts[i]!=2) {
                    System.out.println(0);
                    return;
                }
            }
        }

        long ans = 1;
        for (int i = 0; i < n/2; i++) {
            ans *= 2;
            ans %= MOD;
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