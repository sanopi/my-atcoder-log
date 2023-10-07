import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC323C {

    private static final int INF = 10000000;

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(m);
        List<Integer>[] restPoint = new List[n];
        for (int i = 0; i < n; i++) {
            restPoint[i] = new ArrayList<>();
        }
        int[] currentPoint = new int[n];
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
            currentPoint[i] += (i+1);
            for (int j = 0; j < m; j++) {
                if (s[i].charAt(j) == 'o') {
                    currentPoint[i] += a[j];
                } else {
                    restPoint[i].add(a[j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int myPoint = currentPoint[i];
            int target = 0;
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                target = Math.max(target, currentPoint[j]);
            }
            if (myPoint > target) {
                out.println(0);
                continue;
            }

            int toAdd = target - myPoint + 1;
            List<Integer> rest = restPoint[i];
            int nn = rest.size();
            int[][] dp = new int[nn][toAdd+1];
            for (int j = 0; j < nn; j++) {
                Arrays.fill(dp[j], INF);
            }
            dp[0][0] = 0;
            dp[0][Math.min(toAdd, rest.get(0))] = 1;
            for (int j = 1; j < nn; j++) {
                Integer add = rest.get(j);
                for (int k = 0; k <= toAdd; k++) {
                    // とかない
                    dp[j][k] = Math.min(dp[j][k], dp[j-1][k]);

                    // 解く
                    int to = Math.min(toAdd, k+add);
                    dp[j][to] = Math.min(dp[j][to], dp[j-1][k]+1);
                }
            }
            out.println(dp[nn-1][toAdd]);
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