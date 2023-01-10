import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC284F {
    private static final long B = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        String t = next();
        char[] t1 = t.substring(0, n).toCharArray();
        char[] t2 = new StringBuilder().append(t, n, 2*n).reverse().toString().toCharArray();
        if (Arrays.equals(t1, t2)) {
            System.out.println(new String(t1));
            System.out.println(n);
            return;
        }

        long[] bb = new long[n+1];
        bb[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            bb[i] = bb[i-1]*B;
        }

        long t1h = 0;
        for (int i = 0; i < n; i++) {
            t1h += t1[i]*bb[n-i-1];
        }
        long t2h = 0;
        for (int i = 0; i < n; i++) {
            t2h += t2[i]*bb[n-i-1];
        }

        // i文字ずらす
        for (int i = 1; i <= n; i++) {
            // Sの候補は、n-i文字目 * bb[i-1] がひかれる
            // そこに、2*n-i文字目 * bb[i-1] が足される
            t1h -= t.charAt(n-i) * bb[i-1];
            t1h += t.charAt(2*n-i) * bb[i-1];

            // rSの候補はスライドするので、全体をB倍して、
            // 2*n-i文字目 * bb[n] を引いて、
            // n-i文字目 を足す
            t2h *= B;
            t2h -= t.charAt(2*n-i) * bb[n];
            t2h += t.charAt(n-i);

            if (t1h == t2h) {
                String candidate = new StringBuilder().append(t, 0, n - i).append(t, 2 * n - i, 2 * n).toString();
                if (
                    candidate
                        .equals(new StringBuilder().append(t, n-i, 2*n-i).reverse().toString())
                    ) {
                    System.out.println(candidate);
                    System.out.println(n-i);
                    return;
                }
            }
        }
        System.out.println(-1);
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