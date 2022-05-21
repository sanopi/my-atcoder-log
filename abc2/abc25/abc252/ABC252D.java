import java.io.PrintWriter;
import java.util.Scanner;

public class ABC252D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int[] counts = new int[200001];

        long[] dp2 = new long[n+1];
        long[] dp3 = new long[n+1];

        counts[a[0]]++;

        for (int i = 2; i <= n; i++) {
            int ai = a[i-1];
            int count = counts[ai];
            int j = i - 1 - count;
            dp2[i] = dp2[i-1] + j;
            dp3[i] = dp3[i-1] + dp2[i-1] - ((long)count*(j));
            counts[ai]++;
        }

        out.println(dp3[n]);
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