import java.io.PrintWriter;
import java.util.Scanner;

public class ABC183E {

    private static final int MOD = 1000000007;

    private static long[][] memo;
    private static int h;
    private static int w;
    private static char[][] s;

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = next().toCharArray();
        }
        memo = new long[h][w];
        memo[0][0] = 1;

        // 一個直前のマスまでの合計を保持
        long[][] sumX = new long[h][w];
        long[][] sumY = new long[h][w];
        long[][] sumXY = new long[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j] =='#') continue;

                sumX[i][j] = j>0 ? (sumX[i][j-1]+memo[i][j-1])%MOD : 0;
                sumY[i][j] = i>0 ? (sumY[i-1][j]+memo[i-1][j])%MOD : 0;
                sumXY[i][j] = i>0&&j>0 ? (sumXY[i-1][j-1]+memo[i-1][j-1])%MOD : 0;

                memo[i][j] += (sumX[i][j] + sumY[i][j] + sumXY[i][j]) % MOD;
            }
        }
        out.println(memo[h-1][w-1]);
        out.flush();
    }

    private static final int[] X = {-1, 0, -1};
    private static final int[] Y = {0, -1, -1};


    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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