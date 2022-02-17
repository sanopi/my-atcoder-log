import java.io.PrintWriter;
import java.util.Scanner;

public class ABC108C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();

        int count = 0;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i%k==0) count++;
        }
        ans += (long) count * count * count;
        if (k%2 == 0) {
            int count2 = 0;
            for (int i = 1; i <= n; i++) {
                if (i%k==k/2) count2++;
            }
            ans += (long) count2 * count2 * count2;
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