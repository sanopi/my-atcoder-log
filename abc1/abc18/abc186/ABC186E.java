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

            long gcdNKS = gcd(n, gcd(k, s));
            n = n/gcdNKS;
            k = k/gcdNKS;
            s = s/gcdNKS;

            long gcdNK = gcd(n, k);
            if (gcdNK != 1) {
                out.println(-1);
                continue;
            }

//            solve1(n, s, k);
            solve2(n, s, k);
        }
        out.flush();
    }

    private static void solve2(long n, long s, long k) {
        // K'K ≡ 1 (mod N)
        // K'K + mN ≡ 1 (mod N)
        // => ここからK'とmを求められる
        Tri result = exGCD(k, n);
        // xK + s ≡ 0 (mod N)
        // xK'K ≡ (n-s)k' (mod N)
        long ans = (n - s) % n * result.x % n;
        out.println((ans+n)%n);
    }

    private static void solve1(long n, long s, long k) {
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
        out.println(((n - s)% n * modPow(k, tagainiSo-1, (int) n))% n);
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