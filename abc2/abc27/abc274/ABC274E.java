import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC274E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int nm = n+m;
        Pair[] points = new Pair[nm];
        for (int i = nm-1; i >= 0; i--) {
            points[i] = new Pair(nextInt(), nextInt());
        }

        // bitDP、iのポイントを訪れている && jのポイントに今いる
        // 上n桁が街、下m桁が宝箱
        double[][] dp = new double[1<<nm][nm];
        for (int i = 0; i < 1 << nm; i++) {
            Arrays.fill(dp[i], Double.POSITIVE_INFINITY);
        }

        for (int i = 1; i < 1 << nm; i++) {
            if (Integer.bitCount(i) == 1) {
                for (int j = 0; j < nm; j++) {
                    if ((i & (1<<j)) == 0) continue;

                    Pair pj = points[j];
                    double xDiff = pj.x;
                    double yDiff = pj.y;
                    double cost = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
                    dp[i][j] = cost;
                }
                continue;
            }

            // 今 j にいることを考える
            for (int j = 0; j < nm; j++) {
                if ((i & (1<<j)) == 0) continue;

                int prev = i ^ (1<<j);
                // 一個前の位置がkとする。すなわち、 k->j の移動
                for (int k = 0; k < nm; k++) {
                    if ((i & (1<<k)) == 0) continue;
                    int boosted = 1;
                    for (int b = 0; b < m; b++) {
                        if ((prev&(1<<b)) != 0) boosted*=2;
                    }
                    Pair pj = points[j];
                    Pair pk = points[k];
                    double xDiff = pj.x-pk.x;
                    double yDiff = pj.y-pk.y;
                    double cost = Math.sqrt(xDiff*xDiff + yDiff*yDiff)/boosted;
                    dp[i][j] = Math.min(dp[i][j], dp[prev][k] + cost);
                }
            }
        }
        double ans = Double.POSITIVE_INFINITY;

        for (int i = 1; i < 1 << nm; i++) {
            boolean ok = true;
            int boosted = 1;
            for (int b = 0; b < m; b++) {
                if ((i&(1<<b)) != 0) boosted*=2;
            }
            for (int j = 0; j < n; j++) {
                ok &= (i&(1<<(j+m))) != 0;
            }
            if (ok) {
                for (int j = 0; j < dp[i].length; j++) {
                    Pair pj = points[j];
                    Pair pk = new Pair(0, 0);
                    double xDiff = pj.x-pk.x;
                    double yDiff = pj.y-pk.y;
                    double cost = Math.sqrt(xDiff*xDiff + yDiff*yDiff)/boosted;
                    ans = Math.min(ans, dp[i][j]+cost);
                }
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
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