import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC293E {

    public static void main(String[] args) {
        long a = nextInt();
        long x = nextLong();
        long m = nextInt();
        long ans = solve1(a, x, m);
        out.println(ans);
        out.flush();
    }

    private static Map<Long, Long> memo = new HashMap<>();

    private static long solve1(long a, long x, long m) {
        if (x==1) {
            return 1%m;
        }
        if (x % 2 == 0) {
            long halfX = x / 2;
            long tmp = solve1(a, halfX, m);
            Long mul = memo.computeIfAbsent(halfX, h -> modPow(a, h, m));
            return ((tmp*mul)%m+tmp)%m;
        } else {
            long tmp = solve1(a, x - 1, m);
            return ((tmp*a)%m+1)%m;
        }
    }

    private static long modPow(long a, long n, long mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (1L << i <= n) {
            if ((n & 1L << i) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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