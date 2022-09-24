import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC270C {

    private static List<Integer>[] tree;
    private static int x;
    private static int y;

    public static void main(String[] args) {
        int n = nextInt();
        x = nextInt()-1;
        y = nextInt()-1;
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = nextInt()-1;
            int v = nextInt()-1;
            tree[u].add(v);
            tree[v].add(u);
        }
        List<Integer> result = dfs(y, -1);
        for (Integer integer : result) {
            out.print(integer+1 + " ");
        }
        out.println();
        out.flush();
    }

    private static List<Integer> dfs(int current, int prev) {
        if (current == x) {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(x);
            return res;
        }
        for (Integer next : tree[current]) {
            if (prev == next) continue;
            List<Integer> result = dfs(next, current);
            if (result.size() > 0) {
                result.add(current);
                return result;
            }
        }
        return List.of();
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