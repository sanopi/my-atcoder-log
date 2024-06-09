import java.io.PrintWriter;
import java.util.Scanner;

public class Q01 {

    private static void solve() {
        int n = nextInt();
        int l = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);

        int[] diff = new int[n+1];
        diff[0] = a[0];
        for (int i = 0; i < n - 1; i++) {
            diff[i+1] = a[i+1]-a[i];
        }
        diff[n] = l-a[n-1];

        int ok = 0;
        int ng = l;
        while(ng-ok>1) {
            int mid = (ok+ng)/2;
            int count = 0;
            int sum = 0;
            for (int i = 0; i < n+1; i++) {
                sum+=diff[i];
                if (mid<=sum) {
                    count++;
                    sum = 0;
                }
            }
            if (k+1<=count) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        out.println(ok);
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