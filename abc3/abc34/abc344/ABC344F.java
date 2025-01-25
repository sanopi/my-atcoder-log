import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC344F {

    private static void solve() {
        int n = nextInt();
        int[][] p = new int[n][n];
        int[][] r = new int[n][n-1];
        int[][] d = new int[n-1][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[i][j] = nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                r[i][j] = nextInt();
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = nextInt();
            }
        }

        // DP: [i][j]までに通った道の最高のpがkの時の、最小の手数（同率の場合残りが最大）
        Map<Integer, Result>[][] dp = new Map[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashMap<>();
            }
        }
        dp[0][0].put(p[0][0], new Result(0, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 右
                if (j < n-1) {
                    for (Map.Entry<Integer, Result> entry : dp[i][j].entrySet()) {
                        Integer maxP = entry.getKey();
                        Result currentResult = entry.getValue();
                        long count = currentResult.count;
                        long rest = currentResult.rest;

                        int chargeCount = (int)Math.max(0, (r[i][j]-rest+maxP-1) / maxP);
                        long charge = (long) chargeCount *maxP;

                        Result newValue = new Result(count + chargeCount + 1, rest + charge - r[i][j]);
                        dp[i][j+1].merge(
                                Math.max(maxP, p[i][j+1]),
                                newValue,
                                Result::getGoodOne
                        );
                    }
                }

                // 下
                if (i < n-1) {
                    for (Map.Entry<Integer, Result> entry : dp[i][j].entrySet()) {
                        Integer maxP = entry.getKey();
                        Result currentResult = entry.getValue();
                        long count = currentResult.count;
                        long rest = currentResult.rest;

                        int chargeCount = (int)Math.max(0, (d[i][j]-rest+maxP-1) / maxP);
                        long charge = (long) chargeCount *maxP;

                        Result newValue = new Result(count + chargeCount + 1, rest + charge - d[i][j]);
                        dp[i+1][j].merge(
                                Math.max(maxP, p[i+1][j]),
                                newValue,
                                Result::getGoodOne
                        );
                    }
                }
            }
        }

        long ans = dp[n - 1][n - 1].entrySet().stream().map(Map.Entry::getValue).min(Comparator.comparing(result -> result.count)).get().count;
        out.println(ans);

        out.flush();
    }

    private static class Result {
        long count;
        long rest;
        public Result(long count, long rest) {
            this.count = count;
            this.rest = rest;
        }

        static Result getGoodOne(Result a, Result b) {
            if (a.count < b.count) return a;
            if (b.count < a.count) return b;
            if (a.rest < b.rest) return b;
            else return a;
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