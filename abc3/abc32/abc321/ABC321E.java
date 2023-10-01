import java.io.PrintWriter;
import java.util.Scanner;

public class ABC321E {

    private static void solve() {

        int t = nextInt();
        while (t --> 0) {
            long n = nextLong();
            long x = nextLong();
            long k = nextLong();

            // 全体でnn段ある。
            int nn = 64 - Long.numberOfLeadingZeros(n)-1;
            // xx段目にいる。
            int xx = 64 - Long.numberOfLeadingZeros(x)-1;

            // 一段ずつ上に行くことを考える
            long ans = 0;
            for (int i = 0; i <= xx; i++) {
                if (i==k) {
                    ans += 1;
                    break;
                }
                int diff = nn-(xx-i);
                if ((k-i)>diff) continue;

                if (i==0) {
                    long min = x << k;
                    if (n < min) continue;
                    long max = Math.min(n, min | ((1L << k) - 1));
                    ans += max - min + 1;
                } else {
                    if ((x & (1L<<(i-1))) == 0) {
                        // 右側だけカウント
                        long start = ((x >> i) << 1) + 1;
                        long min = start << (k-i-1);
                        if (n < min) continue;
                        long max = Math.min(n, min | ((1L << (k-i-1)) - 1));
                        ans += max - min + 1;
                    } else {
                        // 左側だけカウント
                        long start = ((x >> i) << 1);
                        long min = start << (k-i-1);
                        if (n < min) continue;
                        long max = Math.min(n, min | ((1L << (k-i-1)) - 1));
                        ans += max - min + 1;
                    }
                }
            }
            out.println(ans);
        }

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