import java.io.PrintWriter;
import java.util.Scanner;

public class ABC262C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt()-1;
        }

        int[] count = new int[n+1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == i) {
                count[i]++;
            }
            count[i] += count[i+1];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            if (ai == i) {
                ans += count[i+1];
            } else if (ai > i) {
                if (a[ai] == i) {
                    ans++;
                }
            }
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