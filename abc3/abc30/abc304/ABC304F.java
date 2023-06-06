import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ABC304F {

    private static final int MOD = 998244353;

    /**
     * 200000までの数で、約数の個数の最大値は17個
     */
    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        Map<Integer, Integer> primes = getPrimes(n);
        Set<Integer> divs = new HashSet<>();
        divs.add(1);
        for (Map.Entry<Integer, Integer> entry : primes.entrySet()) {
            int prime = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                Set<Integer> newList = new HashSet<>(divs);
                for (Integer div : divs) {
                    newList.add(div * prime);
                }
                divs = newList;
            }
        }

        long ans = 0;
        List<Integer> list = divs.stream().sorted(Comparator.naturalOrder()).limit(divs.size()-1).collect(Collectors.toList());
        Map<Integer, Long> memo = new HashMap<>();
        for (Integer div : list) {
            boolean[] must = new boolean[div];
            for (int i = 0; i < n; i+=div) {
                for (int j = 0; j < div; j++) {
                    if (s.charAt(i+j) == '.') {
                        must[j] = true;
                    }
                }
            }

            int notMustCount = 0;
            for (int i = 0; i < div; i++) {
                if (!must[i]) {
                    notMustCount++;
                }
            }
            long add = modPow(2, notMustCount, MOD);

            for (Integer i : divs) {
                if (i.equals(div)) continue;
                if (div%i != 0) continue;
                Long minus = memo.getOrDefault(i, 0L);
                add -= minus;
            }
            memo.put(div, add);
            ans += add;
            ans %= MOD;
            ans = (ans+MOD)%MOD;
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int div;
        Set<Integer> divs;
        public Pair(int div, Set<Integer> divs) {
            this.div = div;
            this.divs = divs;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return div == pair.div && Objects.equals(divs, pair.divs);
        }
        @Override
        public int hashCode() {
            return Objects.hash(div, divs);
        }
        @Override
        public String toString() {
            return "Pair{" +
                "div=" + div +
                ", primes=" + divs +
                '}';
        }
    }

    private static Map<Integer, Integer> getPrimes(int n) {
        Map<Integer, Integer> primes = new HashMap<>();
        int nn = n;
        for (int i = 2; i*i <= nn; i++) {
            while (nn % i == 0) {
                nn/=i;
                primes.merge(i, 1, Math::addExact);
            }
        }
        if (nn != 1) {
            primes.merge(nn, 1, Math::addExact);
        }
        return primes;
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