import java.io.PrintWriter;
import java.util.Scanner;

public class ABC121D {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long ans;
//        ans = solve1(a, b);
        ans = solve2(a, b);
        out.println(ans);
        out.flush();
    }
    private static long solve2(long a, long b) {
        return f0(a-1) ^ f0(b);
    }

    private static long f0(long n) {
        return ((n+1)/2)%2 ^ (n%2==0?n:0);
    }

    private static long solve1(long a, long b) {
        long ans = 0;
        for (int i = 0; i < 63; i++) {
            long expi = 1L << (i);
            long expi1 = 1L << (i + 1);
            long countA = a /expi1*expi + Math.max(0, a % expi1 - expi);
            long countB = (b +1)/expi1*expi + Math.max(0, (b +1) % expi1 - expi);
            ans += expi * ((countB-countA)%2);
        }
        return ans;
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