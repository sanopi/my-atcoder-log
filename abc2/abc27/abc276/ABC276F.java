import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC276F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int maxA = Arrays.stream(a).max().getAsInt()+3;

        BIT bit = new BIT(maxA);
        BIT countBit = new BIT(maxA);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            sum += (bit.sum(maxA-1)-bit.sum(ai-1))*2%MOD;
            sum += (countBit.sum(ai-1)) * 2 * ai %MOD;
            sum += ai;
            sum %= MOD;
            bit.add(ai, ai);
            countBit.add(ai, 1);
            out.println(sum * modPow(((long)i+1)*(i+1), MOD-2, MOD) % MOD);
        }
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

    private static class BIT {
        int n;
        long[] tree;
        BIT(int n) {
            this.n=n;
            tree = new long[n+1];
        }
        private void add(int i, long v) {
            for (int index = i+1; index <= n; index += (index & -index)) {
                tree[index]+=v;
            }
        }
        private long sum(int i) {
            if (i<0) return 0;
            long res = 0;
            for (int index = i+1; index > 0; index -= (index & -index)) {
                res += tree[index];
            }
            return res;
        }

        private static long calcInvCount(int[] array) {
            int len = array.length;
            int max = Arrays.stream(array).max().getAsInt();
            BIT bit = new BIT(max);
            long count = 0;
            for (int i = 0; i < len; i++) {
                bit.add(array[i], 1);
                count += (i+1-bit.sum(array[i]));
            }
            return count;
        }
    }


}