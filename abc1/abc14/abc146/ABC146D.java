import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC146D {

    private static int[] ans;
    private static List<Branch>[] g;
    public static void main(String[] args) {
        int n = nextInt();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(new Branch(i, b));
            g[b].add(new Branch(i, a));
        }
        ans = new int[n-1];
        dfs(0, -1, 0);
        out.println(Arrays.stream(ans).max().getAsInt());
        Arrays.stream(ans).forEach(out::println);
        out.flush();
    }

    private static class Branch {
        int i;
        int to;
        public Branch(int i, int to) {
            this.i = i;
            this.to = to;
        }
    }

    private static void dfs(int current, int prev, int prevColor) {
        int color = 1;
        for (Branch branch : g[current]) {
            if (prev == branch.to) continue;
            if (color == prevColor) color++;
            ans[branch.i] = color;
            dfs(branch.to, current, color++);
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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