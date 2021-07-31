public class Mathematics {

    private static long modPow(int a, int n, int mod) {
        long[] exps = new long[32];
        exps[0] = a;
        long res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
                res = (res * exps[i]) % mod;
            }
            exps[i+1] = (exps[i] * exps[i]) % mod;
            i += 1;
        }

        return res;
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
