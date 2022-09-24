import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC270E {

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextLong();
        long[] a = nextLongArray(n);

        PriorityQueue<Apple> pq = new PriorityQueue<>(Comparator.comparing(apple -> apple.count));
        for (int i = 0; i < n; i++) {
            pq.add(new Apple(i, a[i]));
        }

        long[] ans = new long[n];

        long cycleCount = 0;
        while (!pq.isEmpty()) {
            Apple apple = pq.poll();
            long count = apple.count;
            count -= cycleCount;
            if (count * n <= k) {
                k -= count * n;
                cycleCount += count;
                n--;
            } else {
                long restCycle = k / n;
                k %= n;
                cycleCount += restCycle;
                pq.add(apple);
                break;
            }
        }

        while (!pq.isEmpty()) {
            Apple apple = pq.poll();
            ans[apple.i] = apple.count - cycleCount;
        }

        int i = 0;
        while (k > 0) {
            if (ans[i]>0) {
                ans[i]--;
                k--;
            }
            i++;
        }

        for (long an : ans) {
            out.print(an + " " );
        }
        out.println();
        out.flush();
    }

    private static class Apple {
        int i;
        long count;
        public Apple(int i, long count) {
            this.i = i;
            this.count = count;
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