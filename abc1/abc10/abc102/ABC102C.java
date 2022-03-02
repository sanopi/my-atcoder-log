import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ABC102C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        long ans;

        ans = solve2(a);
//        ans = solve1(a);
        out.println(ans);
        out.flush();
    }

    private static long solve2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i]-=i+1;
        }
        Arrays.sort(a);
        return calc2(a[a.length/2], a);
    }

    private static long solve1(int[] a) {
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        while (Math.abs(min-max)>2) {
            long point1 = (min+min+max)/3;
            long point2 = (min+max+max)/3;
            if (calc(point1, a) <= calc(point2, a)) {
                max = point2;
            } else {
                min = point1;
            }
        }
        return LongStream.range(min, max + 1).map(l -> calc(l, a)).min().getAsLong();
    }

    private static long calc2(long b, int[] array) {
        long res = 0;
        for (int i = 0; i < array.length; i++) {
            res += Math.abs(b-array[i]);
        }
        return res;
    }
    private static long calc(long b, int[] array) {
        long res = 0;
        for (int i = 0; i < array.length; i++) {
            res += Math.abs((b+i+1)-array[i]);
        }
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