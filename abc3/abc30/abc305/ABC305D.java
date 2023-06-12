import java.io.PrintWriter;
import java.util.Scanner;

public class ABC305D {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);

        long[] sum = new long[n+1];
        for (int i = 1; i < n; i++) {
            if (i%2 == 0) {
                sum[i+1] = sum[i] + (a[i]-a[i-1]);
            } else {
                sum[i+1] = sum[i];
            }
        }

        int q = nextInt();
        while (q --> 0) {
            long l = nextInt();
            long r = nextInt();
            int li = lowerBound(a, l);
            if (li % 2 == 1) {
                l = a[li];
            }

            int ri = upperBound(a, r)-1;
            if (ri%2 == 0) {
                r = a[ri];
            }
            out.println(
                Math.max(0,
                    sum[ri+1] - sum[li+1]
                        + (a[li] - l)
                        + (r - a[ri])
                )

            );
        }
        out.flush();
    }

    private static int lowerBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key <= a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }

    private static int upperBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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