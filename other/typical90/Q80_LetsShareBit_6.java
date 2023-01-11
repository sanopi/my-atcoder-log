import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q80_LetsShareBit_6 {

    private static int d;
    public static void main(String[] args) {
        int n = nextInt();
        d = nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }

        out.println(solve2(n, a));
//        out.println(solve3(n, a));
        out.flush();
    }

    private static long solve3(int n, long[] a) {
        // 全体 - 「いずれかの & が 0 になる 数」
        // 「いずれかの & が 0 になる 数」 = 和集合 of 「1つとの & が 0 になる数」
        // 和集合を取る際に包除原理を適用するにあたり、共通集合が必要になる。
        // 共通集合「2つ以上との & が全て 0 になる数」は、1が立っているbitが必ず0になれば良いので、2^(0のbitの数)

        long ans = 1L<<d;
        for (int i = 1; i < 1 << n; i++) {
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                if ((i&(1L<<j)) != 0) {
                    tmp |= a[j];
                }
            }
            long add =  ((Integer.bitCount(i)&1)==1 ? -1 : 1) * (1L<< (d-Long.bitCount(tmp)));
            ans += add;
        }
        return ans;
    }

    private static long solve2(int n, long[] a) {
        if (d==0) {
            return 0;
        }
        long[][] dp = new long[1<< n][d];
        for (int i = 0; i < d; i++) {
            dp[0][i] = 1L<<(i+1);
        }

        int[] aa = new int[d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < n; j++) {
                if ((a[j] & (1L<<i)) != 0) {
                    aa[i] |= 1<<j;
                }
            }
        }

        for (int i = 1; i < 1 << n; i++) {
            for (int j = 0; j < d; j++) {
                int one = i & aa[j];
                int zero = i ^ one;
                if (j == 0) {
                    dp[i][j] = i==one?1:0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[zero][j-1];
                }
            }
        }
        return dp[(1<< n)-1][d-1];
    }

    // TLE
    private static long solve(List<Long> a, int i) {
        if (a.size() == 0) {
            return 1L<<(d-i);
        }
        if (i == d) {
            return 0;
        }

        List<Long> zero = new ArrayList<>();
        List<Long> one = new ArrayList<>();
        for (Long l : a) {
            if ((l & (1L<<i)) == 0) {
                zero.add(l);
            } else {
                one.add(l);
            }
        }

        // i桁目で0を選ぶ場合
        long zeroResult = solve(a, i + 1);
        // i桁目で1を選ぶ場合
        long oneResult;
        if (a.equals(zero)) {
            oneResult = zeroResult;
        } else {
            oneResult = solve(zero, i + 1);

        }
        return zeroResult + oneResult;
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