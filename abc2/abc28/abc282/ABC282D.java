import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC282D {

    private static List<Integer>[] g;
    private static int[] colors;
    private static Set<Integer> ngColors = new HashSet<>();

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            g[u].add(v);
            g[v].add(u);
        }
        colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] != -1) continue;
            dfs_fillColor(i, -1, new int[]{i*2, i*2+1}, 0);
        }
        if (ngColors.size() > 0) {
            System.out.println(0);
            return;
        }

        int[] colorCount = new int[n*2];
        for (int color : colors) {
            colorCount[color]++;
        }
        int okColorSum = 0;
        for (int i = 0; i < n * 2; i++) {
            okColorSum += colorCount[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += okColorSum-(colorCount[colors[i]] + g[i].size());
        }
        out.println(ans/2);
        out.flush();
    }

    private static void dfs_fillColor(int current, int prev, int[] cBase, int colorI) {
        if (colors[current] != -1) {
            if (colors[current] != cBase[colorI]) {
                for (int color : cBase) ngColors.add(color);
            }
            return;
        }
        colors[current] = cBase[colorI];
        for (Integer next : g[current]) {
            if (prev == next) continue;
            dfs_fillColor(next, current, cBase, 1-colorI);
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