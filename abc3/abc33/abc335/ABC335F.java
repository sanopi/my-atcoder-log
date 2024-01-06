import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ABC335F {

    private static final int MOD = 998244353;

    private static void solve() {
        int n = nextInt();
        int[] a = new int[n];;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) {
            int ai = nextInt();
            a[i] = ai;
            copy[i] = ai;
        }

        int root = (int) Math.sqrt(n);
        Arrays.sort(copy);
        Set<Base> bases = new HashSet<>();
        for (int i = 0; i < root; i++) {
            bases.add(new Base(a[i], i%a[i]));
        }

        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Base, Long> memo = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            int ai = a[i];
            Base base = new Base(ai, i % ai);
            if (memo.containsKey(base)) {
                dp[i] += memo.get(base);
            } else {
                for (int j = i+ai; j < n; j+=ai) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
            for (Base base1 : bases) {
                if (i >= base1.d && (i-base1.d) % base1.ai == 0) {
                    memo.merge(base1, dp[i], (l1, l2) -> (l1+l2)%MOD);
                }
            }
        }

        out.println(dp[0]);
        out.flush();
    }

    private static class Base {
        int ai;
        int d;
        public Base(int ai, int d) {
            this.ai = ai;
            this.d = d;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Base base = (Base) o;
            return ai == base.ai && d == base.d;
        }
        @Override
        public int hashCode() {
            return Objects.hash(ai, d);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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