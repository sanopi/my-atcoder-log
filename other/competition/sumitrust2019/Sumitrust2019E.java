import java.io.PrintWriter;
import java.util.Scanner;

public class Sumitrust2019E {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        long ans = 1;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            ans *= (ai==0?3:count[ai-1])-count[ai];
            count[ai]++;
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