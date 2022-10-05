import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC271E {

    private static int n;

    private static final long INF = Long.MAX_VALUE/2;

    public static void main(String[] args) {
        n = nextInt();
        int m = nextInt();
        int k = nextInt();
        Path[] paths = new Path[m];
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            paths[i] = new Path(a, b, c);
        }

        long[] costs = new long[n];
        Arrays.fill(costs, INF);
        costs[0] = 0;
        for (int i = 0; i < k; i++) {
            int e = nextInt()-1;
            Path pe = paths[e];
            costs[pe.b] = Math.min(costs[pe.b], costs[pe.a]+pe.c);
        }
        long ans = costs[n - 1];
        out.println(ans >=INF?-1:ans);
        out.flush();
    }

    private static class Path {
        int a;
        int b;
        long c;
        public Path(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
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