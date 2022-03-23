import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC244F {

    private static int n;
    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }

        int[][] len = new int[n][1<<n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(len[i], Integer.MAX_VALUE);
            len[i][0] = 0;
        }

        Queue<Pair> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            q.add(new Pair(1<<i, i, 1));
            len[i][1<<i] = 1;
        }

        while (!q.isEmpty()) {
            Pair current = q.poll();
            for (Integer nextNode : g[current.last]) {
                Pair next = new Pair((current.i ^ (1<< nextNode)), nextNode, current.count+1);
                if (len[next.last][next.i] > next.count) {
                    len[next.last][next.i] = next.count;
                    q.add(next);
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 1<<n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                min = Math.min(min, len[j][i]);
            }
            ans += min;
        }

        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int i;
        int last;
        int count;
        public Pair(int i, int last, int count) {
            this.i = i;
            this.last = last;
            this.count = count;
        }
    }

    private static String getString(List<Integer> path) {
        int[] ints = new int[n];
        for (Integer i : path) {
            ints[i]++;
            ints[i]%=2;
        }
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = (char) (ints[i]+'0');
        }
        return String.valueOf(chars);
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