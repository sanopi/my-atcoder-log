import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC293E {

    public static void main(String[] args) {
        long a = nextInt();
        long x = nextLong();
        long m = nextInt();
        long ans;
//        ans = solve1(a, x, m);
        ans = solve2(a, x, m);
        out.println(ans);
        out.flush();
    }

    private static long solve2(long a, long x, long m) {
        long[][] matrix = {
            {a, 1},
            {0, 1}
        };
        long[][] result = modPow(matrix, x - 1, m);
        return (result[0][0] + result[0][1])%m;
    }

    private static long[][] modPow(long[][] a, long n, long mod) {
        int index = 0;
        int len = a.length;
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }

        while (1L<<index <= n) {
            if ((1L<<index & n) != 0) {
                res = modMultiply(res, a, mod);
            }
            a = modMultiply(a, a, mod);
            index++;
        }
        return res;
    }

    private static long[][] modMultiply(long[][] a, long[][] b, long mod) {
        int len = a.length;
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += ((long)a[i][k]*b[k][j])%mod;
                    res[i][j]%=mod;
                }
            }
        }
        return res;
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