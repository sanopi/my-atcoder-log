import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC252F {

    public static void main(String[] args) {
        int n = nextInt();
        long l = nextLong();
        int[] a = nextIntArray(n);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add((long)a[i]);
        }
        pq.add(l - Arrays.stream(a).mapToLong(i -> i).sum());

        long cost = 0;
        while (pq.size()>1) {
            Long one = pq.poll();
            if (one == 0) continue;
            Long two = pq.poll();
            cost += one+two;
            pq.add(one+two);
        }
        out.println(cost);
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