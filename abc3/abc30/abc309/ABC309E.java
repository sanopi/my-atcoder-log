import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC309E {

    private static boolean[] ok;
    private static int[] inss;
    private static List<Integer>[] g;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] p = new int[n];
        for (int i = 1; i < n; i++) {
            p[i] = nextInt()-1;
        }
        ok = new boolean[n];
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int pi = p[i];
            g[pi].add(i);
        }
        inss = new int[n];
        for (int i = 0; i < m; i++) {
            int x = nextInt()-1;
            int y = nextInt()+1;
            inss[x] = Math.max(inss[x], y);
        }
//        solve(0, 0);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            if (inss[current] > 0) {
                ok[current] = true;
            }
            for (Integer next : g[current]) {
                inss[next] = Math.max(inss[next], inss[current]-1);
                q.add(next);
            }
        }



        int ans = 0;
        for (boolean b : ok) {
            if (b) {
                ans++;
            }
        }
        out.println(ans);
        out.flush();
    }

//    private static void solve(int current, int ins) {
//        ins = Math.max(ins, inss[current]);
//        if (ins>0) {
//            ok[current] = true;
//        }
//        for (Integer next : g[current]) {
//            solve(next, ins-1);
//        }
//    }

    private static class P {
        int i;
        int ins;
        public P(int i, int ins) {
            this.i = i;
            this.ins = ins;
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