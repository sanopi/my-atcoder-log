import java.io.PrintWriter;
import java.util.Scanner;

public class ABC249D {

    private static final int MAX = 200000;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] count = new int[MAX+1];
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }

        long ans = 0;
        for (int i = 1; i <= MAX; i++) {
            if (count[i] == 0) continue;
            for (int j = 1; j <= MAX / i; j++) {
                if (count[j] == 0) continue;
                if (count[i*j] == 0) continue;
                ans += (long)count[i] * count[j] * count[i*j];
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