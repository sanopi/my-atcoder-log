import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC302E {

    public static void main(String[] args) {
        int n = nextInt();
        Set<Integer>[] g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        Set<Integer> singles = new HashSet<>();
        for (int i = 0; i < n; i++) {
            singles.add(i);
        }

        int q = nextInt();
        while (q --> 0) {
            int t = nextInt();
            if (t == 1) {
                int u = nextInt()-1;
                int v = nextInt()-1;
                g[u].add(v);
                g[v].add(u);
                singles.remove(u);
                singles.remove(v);
            } else {
                int v = nextInt()-1;
                for (Integer next : g[v]) {
                    g[next].remove(v);
                    if (g[next].size() == 0) {
                        singles.add(next);
                    }
                }
                g[v] = new HashSet<>();
                singles.add(v);
            }
            out.println(singles.size());
        }

        out.flush();
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