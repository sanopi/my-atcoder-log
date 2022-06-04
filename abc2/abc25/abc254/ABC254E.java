import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC254E {

    private static List<Integer>[] g;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }

        int q = nextInt();
        while (q --> 0) {
            int x = nextInt()-1;
            int k = nextInt();

            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(x, k));
            long ans = 0;
            HashSet<Integer> set = new HashSet<>();
            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                if (set.contains(current.i)) continue;
                set.add(current.i);
                ans += current.i+1;
                if (current.dep == 0) {
                    continue;
                }

                for (Integer next : g[current.i]) {
                    if (set.contains(next)) continue;
                    queue.add(new Pair(next, current.dep-1));
                }
            }
            out.println(ans);
        }

        out.flush();
    }

    private static class Pair {
        int i;
        int dep;
        public Pair(int i, int dep) {
            this.i = i;
            this.dep = dep;
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