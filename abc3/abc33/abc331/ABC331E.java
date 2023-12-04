import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC331E {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int l = nextInt();
        int[] a = nextIntArray(n);
        B[] b = new B[m];
        for (int i = 0; i < m; i++) {
            int bi = nextInt();
            b[i] = new B(i, bi);
        }
        Arrays.sort(b, Comparator.comparing((B bb) -> -bb.b));
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int c = nextInt()-1;
            int d = nextInt()-1;
            Set<Integer> set = map.getOrDefault(c, new HashSet<>());
            set.add(d);
            map.put(c, set);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            for (int j = 0; j < m; j++) {
                if (map.getOrDefault(i, Set.of()).contains(b[j].i)) continue;
                ans = Math.max(ans, ai+b[j].b);
                break;
            }
        }
        out.println(ans);

        out.flush();
    }

    private static class B {
        int i;
        int b;
        public B(int i, int b) {
            this.i = i;
            this.b = b;
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