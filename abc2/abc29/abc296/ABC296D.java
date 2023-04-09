import java.io.PrintWriter;
import java.util.Scanner;

public class ABC296D {

    public static void main(String[] args) {
        long n = nextLong();
        long m = nextLong();

        long x = Long.MAX_VALUE;
        for (int a = 1; a <= 1000000 && a <= n; a++) {
            long ok = 1000000000000L;
            long ng = 0;
            while (ok-ng>1) {
                long mid = (ok+ng)/2;
                if (a*mid>=m) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            }
            if (ok <= n) {
                x = Math.min(x, a*ok);
            }
        }
        if (x == Long.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(x);
        }
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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