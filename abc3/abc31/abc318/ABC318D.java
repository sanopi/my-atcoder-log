import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC318D {

    private static int n;
    private static long[][] d;
    private static void solve() {
        n = nextInt();
        d = new long[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                long dij = nextInt();
                d[i][j] = dij;
                d[j][i] = dij;
            }
        }
        long ans = rec(0L, new HashSet<>());
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, rec(0L, new HashSet<>(Set.of(i))));
        }
        out.println(ans);
        out.flush();
    }

    private static long rec(long current, Set<Integer> done) {
        long res = current;
        for (int i = 0; i < n; i++) {
            if (done.contains(i)) continue;
            done.add(i);
            for (int j = i+1; j < n; j++) {
                if (done.contains(j)) continue;
                done.add(j);
                long result = rec(current + d[i][j], done);
                res = Math.max(res, result);
                done.remove(j);
            }
            done.remove(i);
            break;
        }
        return res;
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