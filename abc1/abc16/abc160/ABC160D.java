import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC160D {

    public static void main(String[] args) {
        int n = nextInt();
        int x = nextInt()-1;
        int y = nextInt()-1;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            g[i].add(i+1);
        }
        for (int i = 1; i < n; i++) {
            g[i].add(i-1);
        }
        g[x].add(y);
        g[y].add(x);

        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] done = new boolean[n];
            Queue<Pair> queue = new ArrayDeque<>();
            queue.add(new Pair(i, 0));
            done[i] = true;
            while (!queue.isEmpty()) {
                Pair current = queue.poll();
                for (Integer next : g[current.node]) {
                    if (done[next]) {
                        continue;
                    }
                    int nextCount = current.count + 1;
                    queue.add(new Pair(next, nextCount));
                    done[next] = true;
                    counts[nextCount]++;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            out.println(counts[i]/2);
        }
        out.flush();
    }

    private static class Pair {
        int node;
        int count;
        public Pair(int node, int count) {
            this.node = node;
            this.count = count;
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