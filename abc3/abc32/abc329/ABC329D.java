import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC329D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(m);
        int[] count = new int[n];
        TreeSet<C> treeSet = new TreeSet<>(Comparator.comparing((C c) -> -c.c).thenComparing(c -> c.i));
        for (int i = 0; i < m; i++) {
            int ai = a[i]-1;
            count[ai]++;
            treeSet.remove(new C(ai, 0));
            treeSet.add(new C(ai, count[ai]));
            int ans = treeSet.first().i;
            out.println(ans+1);
        }
        out.flush();
    }

    private static class C {
        int i;
        int c;
        public C(int i, int c) {
            this.i = i;
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            C c = (C) o;
            return i == c.i;
        }
        @Override
        public int hashCode() {
            return Objects.hash(i);
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