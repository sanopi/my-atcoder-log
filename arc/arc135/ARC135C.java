import java.io.PrintWriter;
import java.util.Scanner;

public class ARC135C {

    public static void main(String[] args) {
        int n = nextInt();
        int [] a = nextIntArray(n);

        int[] bitCounts = new int[30];
        for (int ai : a) {
            for (int i = 0; i < 30; i++) {
                if (((1<<i) & ai) != 0) {
                    bitCounts[i]++;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i <= n; i++) {
            long candidate = 0;
            int ai = i<n?a[i]:0;
            for (int j = 0; j < 30; j++) {
                if (((1<<j) & ai) != 0) {
                    candidate += (n-bitCounts[j])*(1L<<j);
                } else {
                    candidate += (bitCounts[j])*(1L<<j);
                }
            }
            ans = Math.max(ans, candidate);
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