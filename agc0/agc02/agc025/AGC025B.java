import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class AGC025B {

    private static final int MOD = 998244353;

    private static long[] fact;

    public static void main(String[] args) {
        int n = nextInt();
        long a = nextLong();
        long b = nextLong();
        long k = nextLong();
        Set<Count> set = new HashSet<>();
        for (int red = 0; red <= n; red++) {
            if ((k-red*a) >= 0 && (k-red*a) % b == 0) {
                long blue = (k-red*a) / b;
                if (blue > n) continue;
                set.add(new Count(red, (int)blue));
            }
        }

        fact = new long[n+1];
        fact[0] = 1;
        fact[1] = 1;
        for (int i = 1; i < n; i++) {
            fact[i+1] = fact[i] * (i+1) % MOD;
        }

        long ans = 0;
        for (Count count : set) {
            ans = (ans + modCombination(n, count.r) * modCombination(n, count.b) % MOD) % MOD;
        }
        out.println(ans);
        out.flush();
    }

    private static class Count {
        int r;
        int b;
        public Count(int r, int b) {
            this.r = r;
            this.b = b;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Count count = (Count) o;
            return r == count.r && b == count.b;
        }
        @Override
        public int hashCode() {
            return Objects.hash(r, b);
        }
        @Override
        public String toString() {
            return "Count{" +
                "r=" + r +
                ", b=" + b +
                '}';
        }
    }

    private static long modCombination(int n, int k) {
        long res = fact[n] * modPow(fact[k], MOD-2, MOD) % MOD * modPow(fact[n-k], MOD-2, MOD) % MOD;
        return res;
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