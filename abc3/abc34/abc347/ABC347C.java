import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC347C {

    private static void solve() {
        int n = nextInt();
        if (n == 1) {
            System.out.println("Yes");
            return;
        }
        long a = nextLong();
        long b = nextLong();
        long[] d = nextLongArray(n);
        long[] dd = Arrays.stream(d).map(l -> l%(a+b)).distinct().sorted().toArray();
        n = dd.length;
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            long di = dd[i];
            long target = dd[(i+n-1)%n];

            if (target < di) {
                target += (a+b);
            }
            if (target-di < a) {
                ok = true;
                break;
            }
        }
        if (ok) out.println("Yes");
        else out.println("No");
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