import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC303E {

    private static List<Integer>[] g;

    public static void main(String[] args) {
        int n = nextInt();

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] ans = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            ans[g[i].size()]++;
            if (g[i].size() >= 2) {
                count++;
            }
        }
        ans[2]-=(count)/3*2;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < ans[i]; j++) {
                out.print(i+" ");
            }
        }
        out.println();

        out.flush();
    }
//
//    private static Dist findFar(int current, int prev) {
//        Dist res = new Dist(current, 0);
//        for (Integer next : g[current]) {
//            if (next == prev) continue;
//            Dist far = findFar(next, current);
//            res = Dist.max(res, far);
//        }
//        return res;
//    }
//
//    private static void solve(int current, int prev) {
//        if (g[current].size() > 1) {
//            ans.add()
//        }
//    }
//
//    private static class Dist {
//        int i;
//        int d;
//        public Dist(int i, int d) {
//            this.i = i;
//            this.d = d;
//        }
//        static Dist max(Dist a, Dist b) {
//            if (a.d > b.d) {
//                return a;
//            }
//            return b;
//        }
//    }

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