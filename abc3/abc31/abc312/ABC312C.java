import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC312C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long[] a = nextLongArray(n);
        long[] b = nextLongArray(m);
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i : a) {
            pq.add(i-1);
            pq.add(i);
            pq.add(i+1);
        }
        for (long i : b) {
            pq.add(i-1);
            pq.add(i);
            pq.add(i+1);
        }
        while (!pq.isEmpty()) {
            Long i = pq.poll();
            int aCount = upperBound(a, i);
            int bCount = m-lowerBound(b, i);
            if (aCount >= bCount) {
                out.println(i);
                break;
            }
        }

        out.flush();
    }

    private static int lowerBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key <= a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }

    private static int upperBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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