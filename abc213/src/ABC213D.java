import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC213D {

    static int n;
    static PriorityQueue<Integer>[] g;
    static boolean[] done;

    public static void main(String[] args) {
        n = nextInt();
        g = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            g[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        done = new boolean[n];
        Arrays.fill(done, false);
        solve(0);

        out.flush();
    }

    private static void solve(int town) {
        out.print(town + 1 + " ");
        done[town] = true;
        PriorityQueue<Integer> nexts = g[town];
        while (nexts.peek() != null) {
            Integer next = nexts.poll();
            if (done[next]) {
                continue;
            }
            solve(next);
            out.print(town + 1 + " ");
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}