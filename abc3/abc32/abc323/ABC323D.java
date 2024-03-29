import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC323D {

    private static void solve() {
        long ans;
//        ans = solve1();
        ans = solve2();
        out.println(ans);
        out.flush();
    }

    private static long solve2() {
        int n = nextInt();
        long ans = 0;
        Map<Long, Long> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long s = nextLong();
            long c = nextLong();
            int ng = 31;
            int ok = 0;
            while (ng-ok>1) {
                int mid = (ok+ng)/2;
                if ((s % (1L<<mid)) == 0) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            }
            memo.merge(s / (1L<<ok), c*(1L<<ok), Math::addExact);
        }
        for (Map.Entry<Long, Long> entry : memo.entrySet()) {
            long num = entry.getValue();
            ans += Long.bitCount(num);
        }
        return ans;
    }

    private static long solve1() {
        int n = nextInt();
        TreeMap<Long, Long> treeMap = new TreeMap<>(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            long s = nextLong();
            long c = nextLong();
            treeMap.put(s, c);
        }
        long ans = 0;
        while (!treeMap.isEmpty()) {
            Map.Entry<Long, Long> smallest = treeMap.pollFirstEntry();
            long s = smallest.getKey();
            long c = smallest.getValue();
            if (c/2 > 0) {
                treeMap.merge(2*s, c/2, Math::addExact);
            }
            ans += c%2;
        }
        return ans;
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