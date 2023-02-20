import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC289E {


    public static void main(String[] args) {
        int t = nextInt();
        while (t --> 0) {
            int n = nextInt();
            int m = nextInt();
            int[] c = nextIntArray(n);
            List<Integer>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = nextInt()-1;
                int v = nextInt()-1;
                g[u].add(v);
                g[v].add(u);
            }
            if (c[0] == c[n-1]) {
                out.println(-1);
                continue;
            }

            //t * n + a でグラフを考える
//            List<Integer>[] newG = new List[n*n];
//            for (int i = 0; i < n * n; i++) {
//                newG[i] = new ArrayList<>();
//            }
//
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (c[i] == c[j]) continue;
//                    for (Integer iNext : g[i]) {
//                        for (Integer jNext : g[j]) {
//                            if (c[iNext] == c[jNext]) continue;
//                            newG[i*n+j].add(iNext*n+jNext);
//                        }
//                    }
//                }
//            }

            Queue<Integer> q = new ArrayDeque<>();
            int[] cost = new int[n*n];
            Arrays.fill(cost, -1);
            cost[n-1] = 0;
            q.add(n-1);
            while (!q.isEmpty()) {
                Integer current = q.poll();
                int takahashi = current/n;
                int aoki = current%n;
                for (Integer nextT : g[takahashi]) {
                    for (Integer nextA : g[aoki]) {
                        if (c[nextT] == c[nextA]) continue;
                        int next = nextT*n+nextA;
                        if (cost[next] >= 0) continue;
                        cost[next] = cost[current]+1;
                        q.add(next);
                    }
                }
//                for (Integer next : newG[current]) {
//                    if (cost[next] >= 0) continue;
//                    cost[next] = cost[current]+1;
//                    q.add(next);
//                }
                if (cost[(n-1)*n] >= 0) {
                    break;
                }
            }
            out.println(cost[(n-1)*n]);
        }
        out.flush();
    }

    private static class Node {
        int i;
        int cost;
        public Node(int i, int cost) {
            this.i = i;
            this.cost = cost;
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