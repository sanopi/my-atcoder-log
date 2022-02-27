import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ARC136C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        long ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.abs((a[i])-(a[i-1]));
        }
        ans += Math.abs(a[0]-a[n-1]);
        out.println(Math.max(ans/2, Arrays.stream(a).max().getAsInt()));
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