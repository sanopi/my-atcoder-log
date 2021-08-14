import java.io.PrintWriter;
import java.util.Scanner;

public class Q82_CountingNumbers_3 {

    public static void main(String[] args) {
        int mod = 1000000007;
        long l = nextLong();
        long r = nextLong();

        long ans = 0;

        int lLength = String.valueOf(l).length();
        int rLength = String.valueOf(r).length();
        for (int i = lLength; i <= rLength; i++) {
            long left;
            if (i == lLength) {
                left = l;
            } else {
                left = Long.parseLong("1" + "0".repeat(i-1));
            }
            long right;
            if (i == rLength) {
                right = r;
            } else {
                right = Long.parseLong("9".repeat(i));
            }


            long a = (((left + right) % mod) * i) % mod;
            long b = ((right - left + 1) / 2) % mod;
            long c = ((left + right) % 2 == 0 ? (left + right) / 2 : 0) % mod;
            long d = (i * c) % mod;
            ans = (ans + ((a * b) % mod + d) % mod) % mod;

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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}