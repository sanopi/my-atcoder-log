import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC289B {

    private static boolean[] done;
    private static int[] a;
    private static int[] next;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = nextInt()-1;
        }
        next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < m; i++) {
            next[a[i]] = a[i]+1;
        }

        done = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (done[i]) continue;
            dfs(i);
        }

        out.flush();
    }

    private static void dfs(int current) {
        done[current] = true;
        if (next[current] != -1) {
            dfs(next[current]);
        }
        out.print(current+1 + " ");
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