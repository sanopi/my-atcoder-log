import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC293D {

    private static List<Integer>[] g;
    private static boolean[] done;
    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new List[n*2];
        for (int i = 0; i < n * 2; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            g[i*2].add(i*2+1);
            g[i*2+1].add(i*2);
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            String b = next();
            int nodeA = a*2 + (b.equals("R") ? 1 : 0);

            int c = nextInt()-1;
            String d = next();
            int nodeC = c*2 + (d.equals("R") ? 1 : 0);

            g[nodeA].add(nodeC);
            g[nodeC].add(nodeA);
        }

        done = new boolean[n*2];
        int ok = 0;
        int ng = 0;
        for (int i = 0; i < n * 2; i++) {
            if (done[i]) continue;

            Queue<Node> q = new ArrayDeque<>();
            q.add(new Node(i, -1));

            boolean isOk = false;
            while (!q.isEmpty()) {
                Node node = q.poll();
                int current = node.current;
                int prev = node.prev;
                if (done[current]) {
                    isOk = true;
                    break;
                }
                done[current] = true;
                for (int next : g[current]) {
                    if (prev == next) continue;
                    q.add(new Node(next, current));
                }
            }

            if (isOk) {
                ok++;
            } else {
                ng++;
            }

        }
        out.println(ok+ " " + ng);

        out.flush();
    }

    private static class Node {
        int current;
        int prev;
        public Node(int current, int prev) {
            this.current = current;
            this.prev = prev;
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