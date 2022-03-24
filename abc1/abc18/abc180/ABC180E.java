import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class ABC180E {

    public static void main(String[] args) {
        int n = nextInt();
        Tri[] t = new Tri[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Tri(nextInt(), nextInt(), nextInt());
        }

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        long[][] cost = new long[1<<n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(cost[i], Long.MAX_VALUE/2);
        }
        cost[1][0] = 0;

        while (!q.isEmpty()) {
            Pair current = q.poll();
            for (int i = 0; i < n; i++) {
                if ((current.i & (1<<i)) != 0) continue;
                Tri ct = t[current.last];
                Tri nt = t[i];
                long nextCost = cost[current.i][current.last] + Math.abs(ct.x-nt.x) + Math.abs(ct.y-nt.y) + Math.max(0, nt.z - ct.z);
                int nextI = current.i | (1 << i);
                if (cost[nextI][i] > nextCost) {
                    cost[nextI][i] = nextCost;
                    q.add(new Pair(nextI, i));
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            Tri ct = t[i];
            Tri nt = t[0];
            long nextCost = Math.abs(ct.x-nt.x) + Math.abs(ct.y-nt.y) + Math.max(0, nt.z - ct.z);
            ans = Math.min(ans, cost[(1<<n)-1][i] + nextCost);
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int i;
        int last;
        public Pair(int i, int last) {
            this.i = i;
            this.last = last;
        }
    }

    private static class Tri {
        int x;
        int y;
        int z;
        public Tri(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
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