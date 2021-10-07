import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC221D {

    public static void main(String[] args) {
        int n = nextInt();
        PriorityQueue<Query> pq = new PriorityQueue<>(Comparator.comparing(q -> q.p));
        for (int i = 0; i < n; i++) {
            int l = nextInt()-1;
            pq.add(new Query(1, l));
            pq.add(new Query(-1, l+nextInt()));
        }
        int[] ans = new int[n+1];
        int count = 0;
        Query prev = pq.poll();
        while (!pq.isEmpty()) {
            Query next = pq.poll();
            count += prev.t;
            ans[count] += (next.p - prev.p);
            prev = next;
        }

        for (int i = 1; i <= n; i++) {
            out.print(ans[i] + " ");
        }
        out.flush();
    }

    private static class Query {
        int t;
        int p;
        public Query(final int t, final int p) {
            this.t = t;
            this.p = p;
        }
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