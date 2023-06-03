import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class ABC302F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Pair>[] appears = new List[m];
        for (int i = 0; i < m; i++) {
            appears[i] = new ArrayList<>();
        }
        int[][] ss = new int[n][];
        int[][] costs = new int[n][];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            ss[i] = new int[a];
            costs[i] = new int[a];
            for (int j = 0; j < a; j++) {
                int s = nextInt()-1;
                ss[i][j] = s;
                appears[s].add(new Pair(i, j));
                costs[i][j] = Integer.MAX_VALUE;
            }
        }

        Deque<Cost> deque = new ArrayDeque<>();
        for (Pair pair : appears[0]) {
            deque.add(new Cost(pair, 0));
            costs[pair.i][pair.j] = 0;
        }

        boolean[] doneN = new boolean[n];
        boolean[] doneM = new boolean[m];
        doneM[0] = true;

        while (!deque.isEmpty()) {
            Cost current = deque.poll();
            int ci = current.pair.i;
            int cj = current.pair.j;
            int cc = current.cost;
            if (cc != costs[ci][cj]) continue;
            // コスト0移動 == 同じ列
            if (!doneN[ci]) {
                doneN[ci] = true;
                for (int j = 0; j < costs[ci].length; j++) {
                    if (costs[ci][j] < cc) continue;
                    costs[ci][j] = cc;
                    deque.addFirst(new Cost(new Pair(ci, j), cc));
                }
            }

            // コスト1移動 == 違う列
            if (!doneM[ss[ci][cj]]) {
                doneM[ss[ci][cj]] = true;
                for (Pair next : appears[ss[ci][cj]]) {
                    int ni = next.i;
                    int nj = next.j;
                    if (costs[ni][nj] < cc+1) continue;
                    costs[ni][nj] = cc+1;
                    deque.addLast(new Cost(new Pair(ni, nj), cc+1));
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Pair pair : appears[m - 1]) {
            ans = Math.min(ans, costs[pair.i][pair.j]);
        }
        if (ans == Integer.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(ans);
        }
        out.flush();
    }

    private static class Pair {
        int i;
        int j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static class Cost {
        Pair pair;
        int cost;
        public Cost(Pair pair, int cost) {
            this.pair = pair;
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