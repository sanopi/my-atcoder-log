import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC325F {

    private static void solve() {
        int n = nextInt();
        int[] d = nextIntArray(n);
        int l1 = nextInt();
        int c1 = nextInt();
        int k1 = nextInt();
        int l2 = nextInt();
        int c2 = nextInt();
        int k2 = nextInt();

        // i個目までの区間を、センサー1をj個使った時に必要なセンサー2の最低数
        int[][] dp = new int[n+1][k1+1];
        for (int i = 1; i < n+1; i++) {
            Arrays.fill(dp[i], 100000000);
        }
        for (int i = 0; i < n; i++) {
            int di = d[i];
            for (int j = 0; j <= k1; j++) {
                for (int use = 0; j+use <= k1; use++) {
                    int add = (Math.max(0, di-l1*use) + l2 -1) / l2;
                    dp[i+1][j+use] = Math.min(dp[i+1][j+use], dp[i][j]+add);
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (int j = 0; j <= k1; j++) {
            if (dp[n][j] > k2) continue;
            long candidate = ((long) dp[n][j] * c2) + ((long) j * c1);
            ans = Math.min(ans, candidate);
        }
        if (ans == Long.MAX_VALUE) {
            out.println(-1);
        } else {
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