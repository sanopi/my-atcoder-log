import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC223D {

    private static int[] inCount;
    private static ArrayList<Integer>[] outG;
    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        outG = new ArrayList[n+1];
        inCount = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            outG[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            outG[a].add(b);
            inCount[b]++;
        }

        for (int i = 0; i < n + 1; i++) {
            Collections.sort(outG[i]);
        }

        boolean[] done = new boolean[n+1];
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Integer> hasNoPrev = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inCount[i] == 0) {
                hasNoPrev.add(i);
            }
        }

        while (!hasNoPrev.isEmpty()) {
            int poll = hasNoPrev.poll();
            ans.add(poll);
            done[poll] = true;

            for (final Integer next : outG[poll]) {
                inCount[next]--;
                if (inCount[next] == 0) {
                    hasNoPrev.add(next);
                }
            }
        }
        if (ans.size() != n) {
            out.println(-1);
        } else {
            for (final Integer an : ans) {
                out.print(an + " ");
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