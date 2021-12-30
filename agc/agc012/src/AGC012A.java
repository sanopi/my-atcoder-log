import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AGC012A {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(3*n);
        Arrays.sort(a);
        long ans = 0;
        for (int i = n; i < 3*n; i++) {
            ans += a[i];
            i++;
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