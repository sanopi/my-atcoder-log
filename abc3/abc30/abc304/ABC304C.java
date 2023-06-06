import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC304C {

    public static void main(String[] args) {
        int n = nextInt();
        int d = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }

        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            Pair pi = pairs[i];
            for (int j = i+1; j < n; j++) {
                Pair pj = pairs[j];
                int xDiff = pi.x-pj.x;
                int yDiff = pi.y-pj.y;
                if (xDiff*xDiff+yDiff*yDiff <= d*d) {
                    g[i].add(j);
                    g[j].add(i);
                }
            }
        }

        boolean[] aff = new boolean[n];
        aff[0] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            for (Integer next : g[current]) {
                if (aff[next]) continue;
                aff[next]=true;
                q.add(next);
            }
        }
        for (int i = 0; i < n; i++) {
            out.println(aff[i]?"Yes":"No");
        }
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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