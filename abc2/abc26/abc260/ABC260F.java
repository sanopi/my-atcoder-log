import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC260F {

    public static void main(String[] args) {
        int s = nextInt();
        int t = nextInt();
        int m = nextInt();

        Set<Integer>[] g = new Set[t];
        for (int i = 0; i < t; i++) g[i] = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int u = nextInt();
            int v = nextInt();
            if (u > s) {
                g[u-s-1].add(v);
            } else {
                g[v-s-1].add(u);
            }
        }

        Set<Integer>[] l = new Set[s+1];
        for (int i = 0; i < s+1; i++) l[i] = new HashSet<>();
        for (int i = 0; i < t; i++) {
            Set<Integer> gi = g[i];
            Map<Integer, Integer> ap = new HashMap<>();
            for (Integer next : gi) {
                Set<Integer> foundItems = l[next];
                for (Integer found : foundItems) {
                    if (ap.containsKey(found)) {
                        Integer other = ap.get(found);
                        System.out.println(other + " " + (found+s+1) + " " + next + " " +  (i+s+1));
                        return;
                    } else {
                        ap.put(found, next);
                    }
                }
                l[next].add(i);
            }
        }

        out.println(-1);
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