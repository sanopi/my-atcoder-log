import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC217E {

    public static void main(String[] args) {
        int q = nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < q; i++) {
            int query = nextInt();
            if (query == 1) {
                deque.addLast(nextInt());
            } else if (query == 2) {
                Integer first = pq.poll();
                out.println(first != null ? first : deque.pollFirst());
            } else {
                while (deque.size() > 0) {
                    pq.add(deque.pollFirst());
                }
            }
        }
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