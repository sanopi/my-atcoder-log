import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ABC274D {

    private static final int MAX_SUM = 10000;
    private static final int m = 2 * MAX_SUM + 1;

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        int[] a = nextIntArray(n);
        Queue<Integer> evens = new ArrayDeque<>();
        Queue<Integer> odds = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (i%2==0) {
                evens.add(a[i]);
            } else {
                odds.add(a[i]);
            }
        }

        boolean[] xArray = new boolean[m];
        xArray[MAX_SUM+evens.poll()] = true;

        boolean xOk = isOk(evens, x, xArray);
        boolean[] yArray = new boolean[m];
        yArray[MAX_SUM] = true;
        boolean yOk = isOk(odds, y, yArray);
        out.println((xOk&&yOk)?"Yes":"No");
        out.flush();
    }

    private static boolean isOk(Queue<Integer> nums, int target, boolean[] result) {
        for (Integer num : nums) {
            boolean[] next = new boolean[m];
            for (int i = 0; i < m; i++) {
                if (i-num >= 0) {
                    next[i-num] |= result[i];
                }
                if (i+num < m) {
                    next[i+num] |= result[i];
                }
            }
            result = next;
        }
        return result[target+MAX_SUM];
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