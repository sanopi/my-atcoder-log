import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ARC171B {
    private static final int MOD = 998244353;

    private static void solve() {
        int n = nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = nextInt()-1;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;

        Map<Integer, Integer> usedBy = new HashMap<>();
        Set<Integer> ng = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            int ai = a[i];
            int pi = p[i];
            if (ai < pi) {
                System.out.println(0);
                return;
            }
            p[i] = usedBy.getOrDefault(ai, ai);
            usedBy.put(ai, pi);
            if (ai != pi) {
                ng.add(pi);
            }
        }
        for (int i = 0; i < n; i++) {
            if (ng.contains(a[i])) {
                System.out.println(0);
                return;
            }
        }

        BIT bit = new BIT(n);
        long ans = 1;
        for (int i = 0; i < n; i++) {
            int pi = p[i];
            if (pi == i) {
                long mul = (i + 1) - bit.sum(i);
                ans = ans * mul % MOD;
            }
            bit.add(pi, 1);
        }
        out.println(ans);
        out.flush();
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

class BIT {
    int n;
    long[] tree;
    BIT(int n) {
        this.n=n;
        tree = new long[n+1];
    }
    void add(int i, long v) {
        for (int index = i+1; index <= n; index += (index & -index)) {
            tree[index]+=v;
        }
    }
    long sum(int i) {
        if (i<0) return 0;
        long res = 0;
        for (int index = i+1; index > 0; index -= (index & -index)) {
            res += tree[index];
        }
        return res;
    }

    private static long calcInvCount(int[] array) {
        int len = array.length;
        int max = Arrays.stream(array).max().getAsInt();
        BIT bit = new BIT(max);
        long count = 0;
        for (int i = 0; i < len; i++) {
            bit.add(array[i], 1);
            count += (i+1-bit.sum(array[i]));
        }
        return count;
    }
}

