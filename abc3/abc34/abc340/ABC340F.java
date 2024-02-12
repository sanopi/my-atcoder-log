import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class ABC340F {

    private static void solve() {
        long x = nextLong();
        long y = nextLong();
        if (x == 0) {
            if (2%y == 0) {
                System.out.println(2/y + " " + 0);
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (y == 0) {
            if (2%x == 0) {
                System.out.println(0 + " " + 2/x);
            } else {
                System.out.println(-1);
            }
            return;
        }
        long xx = Math.abs(x);
        long yy = Math.abs(y);


        AtomicLong a = new AtomicLong();
        AtomicLong b = new AtomicLong();
        long result = extended_gcd(xx, yy, b, a);
        if (result>2) {
            out.println(-1);
        } else {
            long al = a.get();
            long bl = b.get();
            if (result == 1) {
                al *= 2;
                bl *= 2;
            }
            if (x < 0) {
                bl = -bl;
            }
            if (y < 0) {
                al = -al;
            }
            out.println(al + " " + (-bl));
        }

        out.flush();
    }

    public static long extended_gcd(long a, long b, AtomicLong x, AtomicLong y)
    {
        if (a == 0)
        {
            x.set(0);
            y.set(1);
            return b;
        }

        AtomicLong _x = new AtomicLong(), _y = new AtomicLong();
        long gcd = extended_gcd(b % a, a, _x, _y);

        x.set(_y.get() - (b/a) * _x.get());
        y.set(_x.get());

        return gcd;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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