import java.io.PrintWriter;
import java.util.Scanner;

public class ARC132A {

    public static void main(String[] args) {
        int n = nextInt();
        int[] rs = nextIntArray(n);
        int[] cs = nextIntArray(n);
        int q = nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int r = nextInt();
            int c = nextInt();
            if (rs[r-1] + cs[c-1] > n) {
                sb.append("#");
            } else {
                sb.append(".");
            }
        }
        out.println(sb.toString());
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