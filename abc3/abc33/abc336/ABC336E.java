import java.io.PrintWriter;
import java.util.Scanner;

public class ABC336E {

    private static void solve() {

        long n = nextLong();
        String s = String.valueOf(n);
        int len = s.length();
        long[] muls = new long[len];
        muls[len-1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            muls[i] = muls[i+1] * 10;
        }
        int MAX_SUM = 9*len;

        long ans = 0;

        for (int f = 1; f <= MAX_SUM; f++) {
            // 上からi桁目まで見て、桁和がjのもので、fで割った余りがkのもので、N未満であるか が何個あるか
            long[][][][] dp = new long[len+1][MAX_SUM+1][f][2];
            dp[0][0][0][0] = 1;

            for (int i = 0; i < len; i++) {
                int digit = s.charAt(i) - '0';
                for (int num = 0; num <= 9; num++) {
                    long add = num * muls[i];

                    for (int j = 0; j+num <= MAX_SUM; j++) {
                        int sum = j + num;
                        for (int k = 0; k < f; k++) {
                            int rest = (int) ((k+add) % f);

                            dp[i+1][sum][rest][1] += dp[i][j][k][1];
                            if (num < digit) {
                                dp[i+1][sum][rest][1] += dp[i][j][k][0];
                            } else if (num == digit) {
                                dp[i+1][sum][rest][0] += dp[i][j][k][0];
                            }
                        }
                    }
                }
            }
            for (long l : dp[len][f][0]) {
                ans += l;
            }
        }

        out.println(ans);
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