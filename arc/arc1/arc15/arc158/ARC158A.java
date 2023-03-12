import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ARC158A {

    public static void main(String[] args) {
        int t = nextInt();
        while ( t --> 0) {
            long x1 = nextInt();
            long x2 = nextInt();
            long x3 = nextInt();
            long[] xx = {x1, x2, x3};
            Arrays.sort(xx);
            long min = xx[0];
            long mid = xx[1];
            long max = xx[2];

            long ans = 0;
            long diff1 = mid-min;
            long diff2 = max-mid;

            long count = Math.min(diff1, diff2) / 2;
            ans += count;

            diff1 -= count*2;
            diff2 -= count*2;

            long count1 = diff1 / 6;
            ans += count1*2;
            diff1 %= 6;

            long count2 = diff2/6;
            ans += count2*2;
            diff2 %= 6;

            if (diff1 == 0 && diff2 == 0) {
                out.println(ans);
            } else {
                out.println(-1);
            }


        }
        out.flush();
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