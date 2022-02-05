import java.io.PrintWriter;
import java.util.Scanner;

public class ABC238C {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        long n = nextLong();
        int length = String.valueOf(n).length();
        long ans = 0;
        for (int i = 1; i < length; i++) {
            long first = Long.parseLong("1"+"0".repeat(i-1));
            long last = Long.parseLong("9".repeat(i));

            long count = last-first+1;

            if (count%2==0) {
                ans += ((1+count)%MOD)*((count/2)%MOD);
            } else {
                ans += ((1+count)/2%MOD)*((count)%MOD);
            }
            ans%=MOD;
        }
        long first = Long.parseLong("1"+"0".repeat(length-1));
        long last = n;
        long count = last-first+1;
        if (count%2==0) {
            ans += ((1+count)%MOD)*((count/2)%MOD);
        } else {
            ans += ((1+count)/2%MOD)*((count)%MOD);
        }
        ans%=MOD;
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