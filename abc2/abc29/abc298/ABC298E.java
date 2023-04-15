import java.io.PrintWriter;
import java.util.Scanner;

public class ABC298E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int a = nextInt()-1;
        int b = nextInt()-1;
        int p = nextInt();
        int q = nextInt();


        long pInv = modPow(p, MOD-2, MOD);
        long qInv = modPow(q, MOD-2, MOD);

        int takahashiTurn = n-a;
        int aokiTurn = n-b;
        // i回サイコロをふった時に、地点jにいる確率
        long[][] takahashi = new long[takahashiTurn][n];
        takahashi[0][a] = 1;
        for (int i = 1; i < takahashiTurn; i++) {
            for (int j = 0; j < n-1; j++) {
                for (int k = 1; k <= p; k++) {
                    int next = Math.min(j + k, n - 1);
                    takahashi[i][next] += takahashi[i-1][j] * pInv;
                    takahashi[i][next] %= MOD;
                }
            }
        }
        // i回サイコロをふった時に、地点jにいる確率
        long[][] aoki = new long[aokiTurn][n];
        aoki[0][b] = 1;
        for (int i = 1; i < aokiTurn; i++) {
            for (int j = 0; j < n-1; j++) {
                for (int k = 1; k <= q; k++) {
                    int next = Math.min(j + k, n - 1);
                    aoki[i][next] += aoki[i-1][j] * qInv;
                    aoki[i][next] %= MOD;
                }
            }
        }
//        for (long[] longs : takahashi) {
//            System.out.println(Arrays.toString(longs));
//        }
//        System.out.println();
//        for (long[] longs : aoki) {
//            System.out.println(Arrays.toString(longs));
//        }

        long ans = 0;
        for (int i = 1; i < Math.min(takahashiTurn, aokiTurn+1); i++) {
            for (int j = 0; j < n-1; j++) {
                ans += (takahashi[i][n-1] * aoki[i-1][j]);
                ans %= MOD;
            }
        }
        out.println(ans);
        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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