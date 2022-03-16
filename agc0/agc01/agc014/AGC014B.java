import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AGC014B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] count = new int[n];
        for (int i = 0; i < m; i++) {
            count[nextInt()-1]++;
            count[nextInt()-1]++;
        }
        boolean ok = Arrays.stream(count).allMatch(i -> i % 2 == 0);
        out.println(ok?"YES":"NO");
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