import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC231E {

    private static long[] a;
    private static int n;

    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        n = nextInt();
        long x = nextLong();
        a = nextLongArray(n);

        out.println(dfs(x, 0));
        out.flush();
    }

    private static long dfs(long x, int i) {
        if (memo.containsKey(x)) {
            return memo.get(x);
        }
        if (i==n-1) return x/a[i];
        if (x == 0) return 0L;

        long current = a[i];
        long next = a[i+1];

        // ぴったり払う
        long nextRest = x % next;
        long l = dfs(x-nextRest, i+1) + (nextRest /current);
        // xもnextもcurrentの倍数なので、 x%next/current は割り切れる。

        // お釣りを貰う
        long addition = nextRest==0 ? 0 : -nextRest+next;
        long ll = dfs(x+addition, i+1) + (addition/current);
        long res = Math.min(l, ll);
        memo.put(x, res);
        return res;
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