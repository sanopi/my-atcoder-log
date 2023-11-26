import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC330C {

    private static void solve() {
        long d = nextLong();
        long ans;
//        ans = solve1(d);
        ans = solve2(d);
        out.println(ans);
        out.flush();
    }
    private static long solve2(long d) {
        long ans = Long.MAX_VALUE;
        for (long x = 0; x*x <= d; x++) {
            double y = Math.sqrt(Math.abs(x * x - d));
            for (long yy = Math.max(0, (int) y-1); yy <= y+1; yy++){
                ans = Math.min(ans, Math.abs(yy*yy+x*x-d));
            }
        }
        return ans;
    }
    private static long solve1(long d) {
        List<Long> squares = new ArrayList<>();
        for (long i = 0; i*i <= 2* d; i++) {
            squares.add(i*i);
        }
        int n = squares.size();
        long[] longs = new long[n];
        for (int i = 0; i < n; i++) {
            longs[i]= squares.get(i);
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long li = longs[i];
            int lFound = lowerBound(longs, -li+ d);
            for (int j = Math.max(0, lFound-100); j < Math.min(n - 1, lFound + 100); j++) {
                ans = Math.min(ans, Math.abs(longs[j]+li- d));
            }
        }
        return ans;
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