import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AGC011B {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        Arrays.sort(a);

        int index = 0;
        for (int i = 0; i < n-1; i++) {
            if (2*a[i] < a[i+1]) {
                index=i+1;
            }
            a[i+1]+=a[i];
        }
        out.println(n-1-index+1);
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