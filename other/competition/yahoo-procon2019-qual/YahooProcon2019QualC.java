import java.io.PrintWriter;
import java.util.Scanner;

public class YahooProcon2019QualC {

    public static void main(String[] args) {
        long k = nextLong();
        long a = nextLong();
        long b = nextLong();

        long ans = 1;
        if (b-a > 2) {
            long p = Math.min(a-1, k);
            k-=p;
            ans += p;

            if (k >= 2) {
                ans += (k/2)*(b-a);
                k = k%2;
            }
        }
        ans += k;
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