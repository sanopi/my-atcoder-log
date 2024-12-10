import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q03 {

    private static void solve() {
        int n = nextInt();
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(b);
            tree[b].add(a);
        }
        Pair pair = findPair(0, tree);
        Pair ans = findPair(pair.a, tree);
        out.println(ans.b+1);

        out.flush();
    }

    private static Pair findPair(int start, List<Integer>[] tree) {
        Queue<Pair> queue = new ArrayDeque<>();
        Pair s = new Pair(start, 0);
        queue.add(s);
        boolean[] done = new boolean[tree.length];
        done[start] = true;
        Pair res = s;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int ci = current.a;
            int cl = current.b;
            done[ci] = true;
            res = current;
            for (Integer next : tree[ci]) {
                if (done[next]) continue;
                Pair pair = new Pair(next, cl + 1);
                queue.add(pair);
            }
        }
        return res;
    }

    private record Pair(int a, int b) {}

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