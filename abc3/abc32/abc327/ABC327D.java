import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC327D {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = nextInt()-1;
        }
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = nextInt()-1;
        }
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int ai = a[i];
            int bi = b[i];
            g[ai].add(bi);
            g[bi].add(ai);
        }
        int[] colors = new int[n];
        Arrays.fill(colors, 2);
        for (int i = 0; i < n; i++) {
            if (colors[i] != 2) continue;
            colors[i] = 0;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(i);
            while (!q.isEmpty()) {
                int current = q.poll();
                int cc = colors[current];
                for (int next : g[current]) {
                    if (colors[next] == 2) {
                        colors[next] = 1-cc;
                        q.add(next);
                    }
                    else if (colors[next] == cc) {
                        System.out.println("No");
                        return;
                    }
                }
            }
        }
        System.out.println("Yes");
        out.flush();
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