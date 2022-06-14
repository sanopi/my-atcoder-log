import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC186E {

    public static void main(String[] args) {
        int t = nextInt();
        while (t-->0) {
            long n = nextInt();
            long s = nextInt();
            long k = nextInt();
            k = (s+k)%n - s;

            if (k==0) {
                out.println(s==0?0:-1);
                continue;
            }
            if (k<0) {
                s = (n-s)%n;
                k = -k;
            }

            long gcdNK = gcd(n, k);
            if (gcdNK != 1) {
                if (s % gcdNK != 0) {
                    out.println(-1);
                    continue;
                }
                n = n/gcdNK;
                k = k/gcdNK;
                s = s/gcdNK;
            }

            Map<Long, Integer> map = new HashMap<>();
            long nn = n;
            for (long i = 2; i*i <= nn; i++) {
                while (nn%i==0) {
                    map.put(i, map.getOrDefault(i, 0)+1);
                    nn /= i;
                }
            }
            if (nn != 1) {
                map.put(nn, map.getOrDefault(nn, 0)+1);
            }
            long tagainiSo = n;
            for (Long key : map.keySet()) {
                tagainiSo *= (key-1);
                tagainiSo /= key;
            }
            out.println(((n-s)%n * modPow(k, tagainiSo-1, (int)n))%n);
        }
        out.flush();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
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