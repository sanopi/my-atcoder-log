import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC226C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] tt = new int[n];
        ArrayList<Integer>[] aaa = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            aaa[i] = new ArrayList<>();
            tt[i] = nextInt();
            int k = nextInt();
            for (int j = 0; j < k; j++) {
                aaa[i].add(nextInt()-1);
            }
        }

        boolean[] must = new boolean[n];
        must[n-1] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(n-1);
        while (!pq.isEmpty()) {
            Integer i = pq.poll();
            for (final Integer a : aaa[i]) {
                if (must[a]) {
                    continue;
                }
                must[a] = true;
                pq.add(a);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (must[i]) {
                ans = ans + (long)tt[i];
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