import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC349D {

    private static void solve() {
        long l = nextLong();
        long r = nextLong();
        List<Pair> ans = new ArrayList<>();

        if (l == 0) {
            long len = Long.highestOneBit(r);
            ans.add(new Pair(l, l+len));
            l += len;
        }

        while (l < r) {
            int trailingZeros = Long.numberOfTrailingZeros(l);
            long len = Math.min(1L<<trailingZeros, Long.highestOneBit(r-l));
            ans.add(new Pair(l, l+len));
            l += len;
        }
        out.println(ans.size());
        for (Pair an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static class Pair {
        long l;
        long r;
        public Pair(long l, long r) {
            this.l = l;
            this.r = r;
        }
        @Override
        public String toString() {
            return l+" "+r;
        }
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