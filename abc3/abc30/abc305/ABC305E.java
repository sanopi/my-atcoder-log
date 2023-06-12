import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC305E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
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

        int[] hs = new int[n];
        Arrays.fill(hs, -1);
        PriorityQueue<P> pq = new PriorityQueue<>(Comparator.comparing(p ->-p.h));
        for (int i = 0; i < k; i++) {
            int p = nextInt()-1;
            int h = nextInt();
            pq.add(new P(p, h));
            hs[p] = h;
        }
        while (!pq.isEmpty()) {
            P current = pq.poll();
            int ci = current.i;
            int ch = current.h;
            if (hs[ci] != ch) continue;
            for (Integer ni : g[ci]) {
                int nh = ch - 1;
                if (hs[ni] >= nh) continue;
                hs[ni] = nh;
                if (nh==0) continue;
                pq.add(new P(ni, nh));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < hs.length; i++) {
            if (hs[i] != -1) {
                ans.add(i+1);
            }
        }
        out.println(ans.size());
        for (Integer i : ans) {
            out.print(i + " " );
        }
        out.println();
        out.flush();
    }

    private static class P {
        int i;
        int h;
        public P(int i, int h) {
            this.i = i;
            this.h = h;
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