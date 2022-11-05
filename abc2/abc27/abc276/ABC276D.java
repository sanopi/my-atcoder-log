import java.io.PrintWriter;
import java.util.Scanner;

public class ABC276D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        long gcd = gcd(a[0], a[1]);
        for (int i = 2; i < n; i++) {
            gcd = gcd(gcd, a[i]);
        }
        for (int i = 0; i < n; i++) {
            a[i] /= gcd;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (a[i] % 2 == 0) {
                ans ++;
                a[i]/=2;
            }
            while (a[i] % 3 == 0) {
                ans ++;
                a[i]/=3;
            }
            if (a[i] != 1) {
                System.out.println(-1);
                return;
            }
        }
        out.println(ans);

        out.flush();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
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