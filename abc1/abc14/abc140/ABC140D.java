import java.io.PrintWriter;
import java.util.Scanner;

public class ABC140D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        String s = next();

        int blockCount = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i-1)) {
                blockCount++;
            }
        }
        blockCount = Math.max(1, blockCount-2*k);
        out.println(n-blockCount);
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