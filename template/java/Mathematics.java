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
        if (b == 0) return a;
        return gcd(b, a % b);
    }


    private static Tri exGCD(long a, long b) {
        if (b == 0) return new Tri(1, 0, a);
        Tri result = exGCD(b, a%b);
        long x = result.y;
        long y = result.x - (a/b)*result.y;
        return new Tri(x, y, result.d);
    }

    private static class Tri {
        long x;
        long y;
        long d;
        public Tri(long x, long y, long d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
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

    private static final long[][] ROTATE_90 = {{0,-1,0},{1,0,0},{0,0,1}};
    private static final long[][] ROTATE_270 = {{0,1,0},{-1,0,0},{0,0,1}};
    private static final double[][] ROTATE(double rad) { return new double[][]{{Math.cos(rad),-Math.sin(rad),0},{Math.sin(rad),Math.cos(rad),0},{0,0,1}};}
    private static final long[][] INVERSE_X(long p) { return new long[][]{{-1,0,2*p},{0,1,0},{0,0,1}};}
    private static final long[][] INVERSE_Y(long p) { return new long[][]{{1,0,0},{0,-1,2*p},{0,0,1}};}
    private static final long[][] SLIDE_X(long p) { return new long[][]{{1,0,p},{0,1,0},{0,0,1}};}
    private static final long[][] SLIDE_Y(long p) { return new long[][]{{1,0,0},{0,1,p},{0,0,1}};}

    /**
     * 座標変換する場合は、行列を左に掛けていく
     */
    private static long[][] multiply(long[][] a, long[][] b) {
        int ar = a.length;
        int ac = a[0].length;
        int bc = b[0].length;
        long[][] res = new long[ar][bc];
        for (int i = 0; i < ar; i++) {
            for (int j = 0; j < bc; j++) {
                for (int k = 0; k < ac; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }
}
