import java.io.PrintWriter;
import java.util.Scanner;

public class AGC021A {

    public static void main(String[] args) {
        String s = next();
        long n = Long.parseLong(s);
        long div = 10;
        int ans = sum(n);
        while (div <= n) {
            n = n/div*div-1;
            ans = Math.max(ans, sum(n));
            div *= 10;
        }
        out.println(ans);
        out.flush();
    }

    private static int sum(long n) {
        int res = 0;
        while (n > 0) {
            res += n%10;
            n /= 10;
        }
        return res;
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