import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC338E {

    private static void solve() {
        int n = nextInt();
        int[] to = new int[4*n];
        for (int i = 0; i < n; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            to[a] = b;
            to[b] = a;
            to[a+2*n] = b+2*n;
            to[b+2*n] = a+2*n;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 4 * n; i++) {
            if (to[i] < i) continue;
            Integer higher = treeSet.higher(i);
            Integer lower = treeSet.lower(to[i]);
            treeSet.add(to[i]);

            if (higher == null && lower == null) continue;
            if (higher != null && to[i] < higher) continue;
            if (lower != null && lower < i) continue;
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
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