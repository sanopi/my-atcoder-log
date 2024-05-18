import java.io.PrintWriter;
import java.util.Scanner;

public class ABC347D {

    private static void solve() {
        int a = nextInt();
        int b = nextInt();
        long c = nextLong();
        long x = 0;
        long y = 0;
        for (int i = 60 - 1; i >= 0; i--) {
            if ((c & (1L<<i)) != 0) {
                if (a+b==0) {
                    System.out.println(-1);
                    return;
                }
                if (a > b) {
                    x |= 1L<<i;
                    a--;
                } else {
                    y |= 1L<<i;
                    b--;
                }
            }
        }

        if (a != b) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < 60; i++) {
            if ((c & (1L<<i)) == 0) {
                if (a+b > 0) {
                    x |= 1L<<i;
                    y |= 1L<<i;
                    a--;
                    b--;
                }
            }
        }
        if (a > 0 || b > 0) {
            System.out.println(-1);
            return;
        }
//        System.out.println(Long.bitCount(x));
//        System.out.println(Long.bitCount(y));
//        System.out.println(x ^ y);


        out.println(x + " " + y);
        out.flush();
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