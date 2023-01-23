import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class ABC286D {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        boolean ok;
//        ok = solve1(n, x);
//        ok = solve2(n, x);
        ok = solve3(n, x);
        out.println(ok ? "Yes" : "No");
        out.flush();
    }

    // 多倍長整数による高速化を更に高速化
    private static boolean solve3(int n, int x) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            int set = 1;
            while (b > 0) {
                set = Math.min(set, b);
                result = result.or(result.shiftLeft(a*set));
                b -= set;
                set <<= 1;
            }
        }
        return result.testBit(x);
    }

    // 多倍長整数による高速化
    private static boolean solve2(int n, int x) {
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            for (int j = 0; j < b; j++) {
                result = result.or(result.shiftLeft(a));
            }
        }
        return result.testBit(x);
    }

    private static boolean solve1(int n, int x) {
        boolean[] ok = new boolean[x +1];
        ok[0] = true;
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            for (int j = 0; j < b; j++) {
                boolean[] next = Arrays.copyOf(ok, ok.length);
                for (int k = 0; k < x + 1; k++) {
                    if (!ok[k]) continue;
                    if (k+a > x) continue;
                    next[k+a] = true;
                }
                ok = next;
            }
        }
        return ok[x];
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