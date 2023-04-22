import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC192E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int x = nextInt()-1;
        int y = nextInt()-1;
        List<Path>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int t = nextInt();
            int k = nextInt();
            g[a].add(new Path(b, t, k));
            g[b].add(new Path(a, t, k));
        }
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[x] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.cost));
        pq.add(new Node(x, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int ci = current.i;
            long cc = current.cost;
            if (cost[ci] != cc) continue;
            for (Path path : g[ci]) {
                int ni = path.to;
                long nc = (cc/path.wait+Math.min(1, cc%path.wait)) * path.wait + path.cost;
                if (cost[ni] <= nc) continue;
                cost[ni] = nc;
                pq.add(new Node(ni, nc));
            }
        }
        if (cost[y] == Long.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(cost[y]);
        }
        out.flush();
    }

    private static class Path {
        int to;
        int cost;
        int wait;
        public Path(int to, int cost, int wait) {
            this.to = to;
            this.cost = cost;
            this.wait = wait;
        }
    }

    private static class Node {
        int i;
        long cost;
        public Node(int i, long cost) {
            this.i = i;
            this.cost = cost;
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