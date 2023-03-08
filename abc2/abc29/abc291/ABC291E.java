import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC291E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = nextInt()-1;
            int y = nextInt()-1;
            g[x].add(y);
        }
        List<Integer> result = topologicalSort(g);
        if (result.size() == n) {
            out.println("Yes");
            int[] ans = new int[n];
            int i = 1;
            for (Integer integer : result) {
                ans[integer] = i++;
            }

            for (Integer integer : ans) {
                out.print(integer + " ");
            }
        }
        else {
            out.println("No");
        }
        out.flush();
    }

    private static List<Integer> topologicalSort(List<Integer>[] graph) {
        int[] inCount = new int[graph.length];
        for (List<Integer> nexts : graph) { for (Integer next : nexts) { inCount[next]++; } }
        // 必要に応じてPriorityQueueなどを使う
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) { if (inCount[i]==0) q.add(i); }
        if (q.size() >= 2) {
            return List.of();
        }
        while (!q.isEmpty()) {
            Integer node = q.poll();
            result.add(node);
            for (final Integer next : graph[node]) {
                inCount[next]--;
                if (inCount[next] == 0) { q.add(next); }
            }
            if (q.size() >= 2) {
                return List.of();
            }
        }
        return result;
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