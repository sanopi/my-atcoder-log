import java.io.PrintWriter;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class ABC350B {

    private static void solve() {
        int n = nextInt();
        int ans;
//        ans = solve1(n);
        ans = solve2(n);
        System.out.println(ans);
        out.flush();
    }

    private static int solve2(int n) {
        BitSet bitSet = new BitSet(n);
        bitSet.set(0, n, true);
        int q = nextInt();
        while (q --> 0) {
            int t = nextInt()-1;
            bitSet.flip(t);
        }
        return bitSet.cardinality();
    }

    private static int solve1(int n) {
        int[] tooth = new int[n];
        Arrays.fill(tooth, 1);
        int q = nextInt();
        while (q --> 0) {
            int t = nextInt()-1;
            tooth[t] ^= 1;
        }
        int res = Arrays.stream(tooth).sum();
        return res;
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