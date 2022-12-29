import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q19_PickTwo_6 {

    private static int[][] memo;
    private static int[] a;

    public static void main(String[] args) {
        int n = nextInt();
        a = nextIntArray(2*n);
        memo = new int[n*2][n*2+1];
        for (int i = 0; i < n * 2; i++) Arrays.fill(memo[i], -1);
        out.println(rec(0, n*2));

        out.flush();
    }

    private static int rec(int l, int r) {
        if (l >= r) return 0;
        if (memo[l][r] >= 0) return memo[l][r];
        int result = Integer.MAX_VALUE;
        // 偶数と偶数
        for (int i = l+2; i <= r-2; i+=2) {
            result = Math.min(result, rec(l, i) + rec(i, r));
        }

        result = Math.min(
            result,
            Math.abs(a[l]-a[r-1]) + rec(l+1, r-1)
        );

        return memo[l][r] = result;
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