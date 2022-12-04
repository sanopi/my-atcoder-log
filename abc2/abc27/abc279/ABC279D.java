import java.io.PrintWriter;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ABC279D {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long min = 0;
        long max = Long.MAX_VALUE/2/b;
        while (max-min>2) {
            long l = (min+min+max)/3;
            long r = (min+max+max)/3;
            if (calc(l, a, b) < calc(r, a, b)) {
                max = r;
            } else {
                min = l;
            }
        }
        out.println(LongStream.rangeClosed(min, max).mapToDouble(d -> calc(d, a, b)).min().getAsDouble());
        out.flush();
    }

    private static double calc(long x, long a, long b) {
        return x*b+(double)a/Math.sqrt(1+x);
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