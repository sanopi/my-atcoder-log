import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC128D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] values = nextIntArray(n);

        int ans = 0;
        for (int cd = 0; cd < Math.min(k, n); cd++) {
            int ab = Math.min(k - cd, n);
            for (int a = 0; a <= ab; a++) {
                Deque<Integer> deque = new ArrayDeque<>();
                for (final int value : values) deque.add(value);
                int b = ab-a;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                int aCount = a;
                while (!deque.isEmpty() && aCount-- > 0) {
                    pq.add(deque.pollFirst());
                }
                while (!deque.isEmpty() && b-- > 0) {
                    pq.add(deque.pollLast());
                }
                int cdCount = cd;
                while (!pq.isEmpty() && pq.peek() < 0 && cdCount-- > 0) {
                    pq.poll();
                }
                int sum = pq.stream().reduce(0, Math::addExact);
                ans = Math.max(ans, sum);
            }
        }
        out.println(ans);
        out.flush();
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