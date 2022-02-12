import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC152E {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        long ans;
        ans = solve(n, a);
        out.println(ans);
        out.flush();
    }

    private static long solve(int n, int[] a) {
        Map<Integer, Integer> primeCounts = new HashMap<>();
        Map<Integer, Integer>[] primes = new HashMap[n];
        for (int i = 0; i < n; i++) {
            primes[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            for (int j = 2; j*j <= ai; j++) {
                int count = 0;
                while (ai%j==0) {
                    ai/=j;
                    count++;
                }
                if (count > 0) {
                    primes[i].put(j, count);
                }
            }
            if (ai>1) {
                primes[i].put(ai, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = primes[i];
            map.forEach((prime, count) -> {
                primeCounts.put(prime, Math.max(count, primeCounts.getOrDefault(prime, 0)));
            });
        }

        long base = 1;
        for (Map.Entry<Integer, Integer> primeCount : primeCounts.entrySet()) {
            base *= modPow(
                primeCount.getKey()
                ,primeCount.getValue()
                ,MOD
            );
            base%=MOD;
        }
        long ans = 0;
        for (int ai : a) {
            ans += base * modPow(ai, MOD-2, MOD);
            ans %= MOD;
        }
        return ans;
    }

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