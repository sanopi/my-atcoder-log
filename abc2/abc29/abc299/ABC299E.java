import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC299E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }
        int k = nextInt();
        Dist[] dists = new Dist[k];
        for (int i = 0; i < k; i++) {
            int p = nextInt()-1;
            int d = nextInt();
            dists[i] = new Dist(p, d);
        }

        // 絶対白じゃなきゃいけないモノ
        boolean[] mustWhite = new boolean[n];
        for (int i = 0; i < k; i++) {
            Dist di = dists[i];
            if (di.d == 0) continue;

            HashSet<Integer> done = new HashSet<>();
            Queue<Dist> q = new ArrayDeque<>();
            q.add(new Dist(di.p, 0));
            done.add(di.p);
            while (!q.isEmpty()) {
                Dist current = q.poll();
                mustWhite[current.p] = true;
                if (current.d >= di.d-1) continue;
                for (Integer next : g[current.p]) {
                    if (done.contains(next)) continue;
                    done.add(next);
                    q.add(new Dist(next, current.d+1));
                }
            }
        }
        boolean ok = true;
        for (int i = 0; i < k; i++) {
            boolean tmpOk = false;
            Dist di = dists[i];
            HashSet<Integer> done = new HashSet<>();
            Queue<Dist> q = new ArrayDeque<>();
            q.add(new Dist(di.p, 0));
            while (!q.isEmpty()) {
                Dist current = q.poll();
                if (current.d == di.d) {
                    if (!mustWhite[current.p]) {
                        tmpOk = true;
                    }
                    continue;
                }
                for (Integer next : g[current.p]) {
                    if (done.contains(next)) continue;
                    done.add(next);
                    q.add(new Dist(next, current.d+1));
                }
            }
            ok &= tmpOk;
        }
        if (ok) {
            out.println("Yes");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (mustWhite[i]) {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            }
            out.println(sb);
        } else {
            out.println("No");
        }

        out.flush();
    }

    private static class Dist {
        int p;
        int d;
        public Dist(int p, int d) {
            this.p = p;
            this.d = d;
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