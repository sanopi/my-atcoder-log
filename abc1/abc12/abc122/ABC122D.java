import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC122D {

    private static final int MOD = 1000000007;

    private static void solve() {
        int n = nextInt();
        if (n == 3) {
            System.out.println(61);
            return;
        }
        Set<List<Integer>> ngs = new HashSet<>();
        List<Integer> minNg = List.of(0, 1, 2);
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        boolean isNg = false;
                        for (List<Integer> l : List.of(
                            List.of(i, i1, i2, i3),
                            List.of(i1, i, i2, i3),
                            List.of(i, i2, i1, i3),
                            List.of(i, i1, i3, i2)
                        )) {
                            if (l.subList(0, 3).equals(minNg) || l.subList(1, 4).equals(minNg)) {
                                isNg = true;
                            }
                        }
                        if (isNg) {
                            ngs.add(List.of(i, i1, i2, i3));
                        }

                    }
                }
            }
        }

        long[][][][][] dp = new long[n][4][4][4][4];
        for (int i = 0; i < 4; i++) {
            for (int i1 = 0; i1 < 4; i1++) {
                for (int i2 = 0; i2 < 4; i2++) {
                    for (int i3 = 0; i3 < 4; i3++) {
                        if (!ngs.contains(List.of(i, i1, i2, i3))) {
                            dp[3][i][i1][i2][i3] = 1;
                        }
                    }
                }
            }
        }

        for (int nn = 4; nn < n; nn++) {
            for (int i = 0; i < 4; i++) {
                for (int i1 = 0; i1 < 4; i1++) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        for (int i3 = 0; i3 < 4; i3++) {
                            if (ngs.contains(List.of(i, i1, i2, i3))) continue;
                            dp[nn][i][i1][i2][i3] = (
                                dp[nn-1][0][i][i1][i2] +
                                dp[nn-1][1][i][i1][i2] +
                                dp[nn-1][2][i][i1][i2] +
                                dp[nn-1][3][i][i1][i2]
                            ) % MOD;
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (long[][][] longs : dp[n - 1]) {
            for (long[][] aLong : longs) {
                for (long[] longs1 : aLong) {
                    for (long l : longs1) {
                        ans += l;
                        ans %= MOD;
                    }
                }
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