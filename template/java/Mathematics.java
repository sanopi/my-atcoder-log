public class Mathematics {

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
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
        return a * b / gcd(a, b);
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
}
