public class Mathematics {

    /**
     * n*(n-1)*...*(n-k+1)
     * を
     * (n-k)!で割る
     */
    private static long modCombination(long n, long k, int mod) {
        if (n<k) return 0;
        long numerator = modFact(n, n-k, mod);
        long denominator = modFact(k, 0, mod);
        long invDenominator = modPow(denominator, mod - 2, mod);

        return numerator * invDenominator % mod;
    }

    private static long modFact(long from, long toEx, int mod) {
        if (from == toEx) {
            return 1;
        }
        return from * modFact(from-1, toEx, mod) % mod;
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

    private static long gcd(long a, long b) {
        if (a % b == 0) { return b; }
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private static int[] getSmallestPrimeFactorArray(int size) {
        int[] spf = new int[size+1];
        for (int i = 0; i <= size; i++) {
            spf[i] = i;
        }
        for (int i = 2; i <= size; i++) {
            if (spf[i] == i) {
                if ((long)i * (long)i > size) {
                    continue;
                }
                for (int j = i * i; j <= size; j+=i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }

    private static int[][] modPow(int[][] a, long n, int mod) {
        int index = 0;
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }

        while (1L<<index <= n) {
            if ((1L<<index & n) != 0) {
                res = modMultiply(res, a, mod);
            }
            a = modMultiply(a, a, mod);
            index++;
        }
        return res;
    }

    private static int[][] modMultiply(int[][] a, int[][] b, int mod) {
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += ((long)a[i][k]*b[k][j])%mod;
                    res[i][j]%=mod;
                }
            }
        }
        return res;
    }
}
