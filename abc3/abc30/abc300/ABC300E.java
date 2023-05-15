import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC300E {

    private static final int MOD = 998244353;
    private static final long inv6 = modPow(6, MOD-2, MOD);
    private static final long inv5 = modPow(5, MOD-2, MOD);
    private static final Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        long n = nextLong();
        out.println(solve(n));
        out.flush();
    }

    private static long solve(long n) {
        if (n == 1) return 1;
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long ans = 0;
        for (int i = 2; i <= 6; i++) {
            if (n%i==0) {
                ans += (solve(n/i)*inv5)%MOD;
                ans %= MOD;
            }
        }
        memo.put(n, ans);
        return ans;
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