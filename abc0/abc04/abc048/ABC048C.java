import java.io.PrintWriter;
import java.util.Scanner;

public class ABC048C {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        int[] a = nextIntArray(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = a[i]+(i>0?a[i-1]:0);
            a[i] -= Math.max(0, sum-x);
            ans+=Math.max(0, sum-x);
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