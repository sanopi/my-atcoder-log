import java.io.PrintWriter;
import java.util.Scanner;

public class ABC269F {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int q = nextInt();

        long modInv2 = modPow(2, MOD-2, MOD);

        while (q-- > 0) {
            long a = nextInt();
            long b = nextInt();
            long c = nextInt();
            long d = nextInt();
            long width = d-c+1;
            long height = b - a + 1;


            long smCount;
            if ((width & 1) == 0) {
                smCount = width/2;
            } else {
                smCount = width/2 + ((((d+a+1)%2)==0)? 1: 0);
            }
            long fmCount = width-smCount;

            long ans = width*(((a-1)*m%MOD+d) + ((a-1)*m%MOD+c))%MOD*modInv2%MOD + smCount*m%MOD;
            ans %= MOD;
            long diff2 = (fmCount+smCount)*m*2 %MOD;
            long repeatCount = height / 2 % MOD;
            ans *= repeatCount;
            ans %= MOD;
            ans += repeatCount * (repeatCount-1)%MOD * diff2%MOD * modInv2 % MOD;
            ans %= MOD;

            if (height % 2 == 1) {
                long first;
                if ((c+b)%2==0) {
                    first = ((b-1)*m+c)%MOD;
                } else {
                    first = ((b-1)*m+c+1)%MOD;
                }

                ans += (fmCount*(2*first+(fmCount-1)*2)%MOD*modInv2%MOD);

            }
            ans %= MOD;
            out.println(ans);
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

}