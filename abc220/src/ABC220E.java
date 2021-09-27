import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.max;

public class ABC220E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int d = nextInt();
        long[] exp = new long[n];
        exp[0] = 1;
        for (int i = 1; i < n; i++) {
            exp[i] = (exp[i-1] * 2) % MOD;
        }

        long ans = 0;
        // 頂点(LCA)に対しての深さを固定して、 頂点の選び方 * 左の候補数 * 右の候補数の計算を行う
        // O(d)の計算量（模範回答のO(N)には劣るが2倍程度の差なのでほぼ誤差）
        for (int ld = 0; ld <= d; ld++) {
            int rd = d-ld;
            int depth = max(ld, rd);
            if (depth < n) {
                // LCAの選び方は等比数列の和。((ar^n-1)/(r-1))のa=1,r=2なので(r^n-1)
                // 深さがdの場合、LCAの最大の深さはn-depth。
                long rootCase = exp[n-depth]-1;
                // 頂点に対しての左側の個数は、深さ0で1つ。1でも1つ。2で2つ。
                long tmp = (exp[max(ld - 1, 0)] * exp[max(rd - 1, 0)]) % MOD;
                tmp = (tmp * rootCase) % MOD;
                ans = (ans + tmp) % MOD;
            }
        }
        // (i,j)の組みは左右を入れ替えても区別する
        ans *= 2;
        ans %= MOD;

        out.println(ans);
        out.flush();
    }

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