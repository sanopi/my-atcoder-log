import java.io.PrintWriter;
import java.util.Scanner;

public class ABC318E {

    private static void solve() {
        int n = nextInt();
        long[] rCount = new long[n];
        long[] lCount = new long[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt()-1;
            rCount[a[i]]++;
        }
        long current = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            long minus = rCount[ai]*lCount[ai];
            rCount[ai]--;
            current-=minus;

            ans+=current;

            lCount[ai]++;
            long plus = rCount[ai]*lCount[ai];
            current+=plus;
        }
        out.println(ans);
        out.flush();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> System.exit(1));
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