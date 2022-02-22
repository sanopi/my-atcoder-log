import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC160E {

    public static void main(String[] args) {
        int x = nextInt();
        int y = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int[] pp = nextIntArray(a);
        int[] qq = nextIntArray(b);
        int[] rr = nextIntArray(c);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(pp).boxed().sorted(Comparator.reverseOrder()).limit(x).forEach(pq::add);
        Arrays.stream(qq).boxed().sorted(Comparator.reverseOrder()).limit(y).forEach(pq::add);

        PriorityQueue<Integer> rpq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : rr) rpq.add(i);

        while (!pq.isEmpty() && !rpq.isEmpty()) {
            Integer first = pq.poll();
            Integer candidate = rpq.poll();
            if (candidate < first) {
                pq.add(first);
                break;
            }

            pq.add(candidate);
        }

        out.println(pq.stream().mapToLong(i->i).sum());
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