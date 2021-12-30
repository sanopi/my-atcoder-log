import java.io.PrintWriter;
import java.util.Scanner;

public class AGC019A {

    private static long q;
    private static long h;
    private static long s;
    private static long d;
    public static void main(String[] args) {
        q = nextInt();
        h = nextInt();
        s = nextInt();
        d = nextInt();
        long n = nextInt();
        out.println(getAns(n));
        out.flush();
    }

    private static long getAns(long n) {
        long ans = Long.MAX_VALUE;
        ans = Math.min(ans , n*4* q);
        ans = Math.min(ans , n*2* h);
        ans = Math.min(ans , n* s);
        if (n == 1L) {
            return ans;
        }
        if (n%2==0) {
            ans = Math.min(ans , n/2* d);
        } else {
            ans = Math.min(ans , (n-1)/2*d + getAns(1L));
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