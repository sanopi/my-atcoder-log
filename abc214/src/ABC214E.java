import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC214E {

    public static void main(String[] args) {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            Map<Integer, List<Integer>> lrs = new TreeMap<>();

            for (int j = 0; j < n; j++) {
                int l = nextInt();
                int r = nextInt();
                List<Integer> rs = lrs.getOrDefault(l, new ArrayList<>());
                rs.add(r);
                lrs.put(l, rs);
            }

            int currentBox = 1;
            boolean ok = true;
            Queue<Integer> q = new ArrayDeque<>(lrs.keySet());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            while (true) {
                Integer l = q.peek();
                if (l != null && currentBox >= l) {
                    pq.addAll(lrs.get(l));
                    q.poll();
                }

                Integer r = pq.poll();
                if (r == null) {
                    if (l == null) {
                        break;
                    }
                    currentBox = l;
                    continue;
                }
                if (currentBox <= r) {
                    currentBox++;
                    continue;
                } else {
                    ok = false;
                    break;
                }
            }
            out.println(ok ? "Yes" : "No");
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

