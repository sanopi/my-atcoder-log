import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q62_PaintAll_6 {


    private static boolean[] done;
    private static List<Integer>[] g;
    private static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int n = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        Set<Integer> hasSelf = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            if (i == a) hasSelf.add(a);
            else g[a].add(i);
            if (i == b) hasSelf.add(b);
            else g[b].add(i);
        }
        done = new boolean[n];
        for (Integer s : hasSelf) {
            dfs(s);
        }
        if (ans.size() != n) {
            System.out.println(-1);
            return;
        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            out.println(ans.get(i)+1);
        }

        out.flush();
    }

    private static void dfs(int current) {
        if (done[current]) return;
        done[current] = true;
        ans.add(current);
        for (Integer next : g[current]) {
            dfs(next);
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