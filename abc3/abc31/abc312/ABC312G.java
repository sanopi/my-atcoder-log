import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC312G {

    private static List<Count>[] tree;
    private static long ans = 0;

    public static void main(String[] args) {
        int n = nextInt();
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            tree[a].add(new Count(b, 0));
            tree[b].add(new Count(a, 0));
        }
        fillCount(0, -1);
        dfs(0, -1, 0);
        out.println(ans);
        out.flush();
    }

    private static int fillCount(int current, int prev) {
        int sum = 1;
        for (Count next : tree[current]) {
            if (next.to == prev) continue;
            int result = fillCount(next.to, current);
            next.c = result;
            sum += result;
        }
        return sum;
    }

    private static void dfs(int current, int prev, int count) {
        List<Integer> counts = new ArrayList<>();
        counts.add(count);
        int sum = count;
        long sqSum = (long)count*count;
        long triSum = (long)count*count*count;
        for (Count c : tree[current]) {
            sum += c.c;
            sqSum += (long)c.c*c.c;
            triSum += (long)c.c*c.c*c.c;
            counts.add(c.c);
        }
        for (Count next : tree[current]) {
            if (next.to == prev) continue;
            dfs(next.to, current, sum-next.c+1);
        }
        long result = (long)sum*sum*sum;
        result -= triSum;
        result -= (sqSum*sum-triSum)*3;
        ans += result/6;
    }

    private static class Count {
        int to;
        int c;
        public Count(int to, int c) {
            this.to = to;
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