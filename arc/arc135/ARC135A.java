import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ARC135A {

    private static final int MOD = 998244353;
    private static final Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        long x = nextLong();
        out.println(memoRec(x));
        out.flush();
    }

    private static long memoRec(long x) {
        if (x <= 4) {
            return x;
        }
        Long memoed = memo.get(x);
        if (memoed != null) {
            return memoed;
        }

        long res = 1;
        res *= memoRec(x/2);
        res %= MOD;
        res *= memoRec((x+1)/2);
        res %= MOD;

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