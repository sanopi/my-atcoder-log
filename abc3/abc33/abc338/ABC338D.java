import java.io.PrintWriter;
import java.util.Scanner;

public class ABC338D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = nextInt()-1;
        }

        long ans;
        ans = solve1(n, m, x);
        ans = solve2(n, m, x);
        out.println(ans);
        out.flush();
    }
    private static long solve2(int n, int m, int[] x) {
        // 橋n-1を使わないパターンから徐々にずらす。
        long tmp = 0;
        long[] add = new long[n];
        for (int i = 0; i < m - 1; i++) {
            int min = Math.min(x[i + 1], x[i]);
            int max = Math.max(x[i + 1], x[i]);
            tmp += max - min;
            int diff = max - min;
            add[min] += - diff + (n - diff);
            add[max] += + diff - (n - diff);
        }
        long ans = tmp;
        for (int i = 0; i < n-1; i++) {
            tmp += add[i];
            ans = Math.min(ans, tmp);
        }

        return ans;
    }
    private static long solve1(int n, int m, int[] x) {
        // 橋iを使わない時の、ツアーの長さ
        long[] memo = new long[n +1];
        for (int i = 0; i < m - 1; i++) {
            int from = x[i];
            int to = x[i+1];
            int min = Math.min(from, to);
            int max = Math.max(from, to);
            int next = min+ n;
            memo[min] += next-max;
            memo[max] -= next-max;
            memo[max] += max-min;
            memo[n] -= max-min;
            memo[0] += max-min;
            memo[min] -= max-min;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            memo[i+1] += memo[i];
        }
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, memo[i]);
        }
        return ans;
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