import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q03 {

    private static int n;
    private static List<Integer>[] g;
    private static void solve() {
        n = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        Node result = getTreeDiameter();
        out.println(result.dist+1);
        out.flush();
    }

    private static Node getTreeDiameter() {
        return find(find(0).i);
    }

    private static class Node {
        int i;
        int dist;
        public Node(int i, int dist) {
            this.i = i;
            this.dist = dist;
        }
    }

    private static Node find(int s) {
        boolean[] done = new boolean[n];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(s, 0));
        done[s] = true;
        Node res = null;
        while (!q.isEmpty()) {
            Node current = q.poll();
            res = current;
            int ci = current.i;
            int di = current.dist;
            for (Integer next : g[ci]) {
                if (done[next]) continue;
                done[next] = true;
                q.add(new Node(next, di+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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