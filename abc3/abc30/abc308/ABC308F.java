import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ABC308F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long[] p = nextLongArray(n);
        long[] l = nextLongArray(m);
        long[] d = nextLongArray(m);
        Coupon[] coupons = new Coupon[m];
        for (int i = 0; i < m; i++) {
            coupons[i] = new Coupon(l[i], d[i]);
        }
        Arrays.sort(p);
        Arrays.sort(coupons, Comparator.comparing(coupon -> coupon.l));
        Queue<Coupon> couponQueue = new ArrayDeque<>();
        for (Coupon coupon : coupons) {
            couponQueue.add(coupon);
        }
        PriorityQueue<Coupon> pq = new PriorityQueue<>(Comparator.comparing(coupon -> -coupon.d));
        int discountableCount = 0;
        long minusSum = 0;
        for (int i = 0; i < n; i++) {
            long pi = p[i];
            if (!couponQueue.isEmpty() &&couponQueue.peek().l <= pi) {
                while (discountableCount > 0 && !pq.isEmpty()) {
                    Coupon current = pq.poll();
                    minusSum+=current.d;
                    discountableCount--;
                }
                discountableCount=1;
                while (!couponQueue.isEmpty() && couponQueue.peek().l <= pi) {
                    pq.add(couponQueue.poll());
                }
            } else {
                discountableCount+=1;
                continue;
            }
        }
        while (discountableCount > 0 && !pq.isEmpty()) {
            Coupon current = pq.poll();
            minusSum+=current.d;
            discountableCount--;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += p[i];
        }
        out.println(ans-minusSum);
        out.flush();
    }

    private static class Coupon {
        long l;
        long d;
        public Coupon(long l, long d) {
            this.l = l;
            this.d = d;
        }
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