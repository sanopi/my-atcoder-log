import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC246C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int x = nextInt();
        int[] a = nextIntArray(n);
        Arrays.sort(a);

        for (int i = n - 1; i >= 0; i--) {
            int ai = a[i];
            int diff = Math.min(k, ai / x);
            k -= diff;
            ai -= diff*x;
            a[i] = ai;
        }
        Arrays.sort(a);
        for (int i = n - 1; i >= 0; i--) {
            if (k==0) {
                break;
            }
            a[i] = 0;
            k--;
        }
        long ans = 0;
        for (int i : a) {
            ans+=i;
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