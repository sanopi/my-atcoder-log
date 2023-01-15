import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC285D {

    private static boolean[] done;
    private static List<Integer>[] g;

    public static void main(String[] args) {
        int n = nextInt();
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            String s = next();
            String t = next();
            Integer si = map.get(s);
            if (si == null) {
                map.put(s, index);
                si = index++;
            }
            Integer ti = map.get(t);
            if (ti == null) {
                map.put(t, index);
                ti = index++;
            }
            pairs[i] = new Pair(si, ti);
        }
        g = new List[index];
        for (int i = 0; i < index; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int s = pairs[i].s;
            int t = pairs[i].t;
            g[s].add(t);
//            g[t].add(s);
        }

        done = new boolean[index];

        boolean hasLoop = false;
        for (int i = 0; i < index; i++) {
            if (done[i]) continue;
            hasLoop |= dfs(i, new HashSet<>());
        }

        out.println(hasLoop ? "No" : "Yes");
        out.flush();
    }

    private static boolean dfs(int current, Set<Integer> set) {
        done[current] = true;
        if (set.contains(current)) {
            return true;
        }
        set.add(current);
        boolean res = false;
        for (int next : g[current]) {
            res |= dfs(next, set);
        }
        return res;
    }

    private static class Pair {
        int s;
        int t;
        public Pair(int s, int t) {
            this.s = s;
            this.t = t;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "s=" + s +
                ", t=" + t +
                '}';
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