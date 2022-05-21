import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC252B {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);
        int[] b = nextIntArray(k);

        int max = Arrays.stream(a).max().getAsInt();
        boolean yes = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == max) {
                for (int j = 0; j < k; j++) {
                    if (b[j]-1 == i) {
                        yes = true;
                        break;
                    }
                }
            }
        }
        out.println(yes?"Yes":"No");
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