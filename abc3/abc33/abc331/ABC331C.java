import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC331C {

    private static void solve() {
        int n = nextInt();
        int[] a = nextIntArray(n);
        TreeMap<Integer, Long> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int ai= a[i];
            treeMap.merge(ai, (long)ai, Math::addExact);
        }
        Map<Integer, Long> ans = new HashMap<>();
        long tmp = 0;
        while (!treeMap.isEmpty()) {
            Map.Entry<Integer, Long> entry = treeMap.pollLastEntry();
            ans.put(entry.getKey(), tmp);
            tmp+=entry.getValue();
        }
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            out.print(ans.get(ai) + " ");
        }
        out.println();
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