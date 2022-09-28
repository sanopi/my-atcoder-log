import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC188E {

    private static List<Integer>[] tree;
    private static long[] sellMax;
    private static long ans = Integer.MIN_VALUE;
    private static int[] a;

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        a = nextIntArray(n);
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            tree[x].add(y);
        }

        sellMax = new long[n];
        Arrays.fill(sellMax, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dfs(i, a[i])-a[i]);
        }
        out.println(ans);
        out.flush();
    }

    private static long dfs(int current, int buyMin) {
        if (sellMax[current]>Integer.MIN_VALUE) return sellMax[current];
        long res = Integer.MIN_VALUE;
        for (Integer next : tree[current]) {
            int nextBuyMin = Math.min(buyMin, a[next]);
            res = Math.max(res, Math.max(dfs(next, nextBuyMin), a[next]));
        }
        ans = Math.max(ans, res-buyMin);
        return sellMax[current] = res;
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