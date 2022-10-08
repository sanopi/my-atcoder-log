import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC272D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] squared = new int[m+1];
        Arrays.fill(squared, -1);
        for (int i = 0; i*i <= m; i++) {
            squared[i*i]=i;
        }

        List<Diff> additions = new ArrayList<>();

        for (int i = 0; i*i <= m; i++) {
            int ii = i * i;
            int rest = m - ii;
            if (squared[rest] != -1) {
                int j = squared[rest];
                additions.add(new Diff(i, j));
                additions.add(new Diff(-i, j));
                additions.add(new Diff(i, -j));
                additions.add(new Diff(-i, -j));
                additions.add(new Diff(j, i));
                additions.add(new Diff(-j, i));
                additions.add(new Diff(j, -i));
                additions.add(new Diff(-j, -i));
            }
        }

        int[][] ans = new int[n][n];
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 0));
        while (!q.isEmpty()) {
            Pair current = q.poll();
            for (Diff addition : additions) {
                int nx = current.x + addition.x;
                int ny = current.y + addition.y;
                if (!(0<=nx && nx<n && 0<=ny && ny<n)) continue;
                int nc = current.count + 1;
                if (ans[nx][ny] > nc) {
                    ans[nx][ny] = nc;
                    q.add(new Pair(nx, ny, nc));
                }
            }
        }
        for (int[] an : ans) {
            for (int i : an) {
                if (i == Integer.MAX_VALUE) {
                    out.print(-1 + " ");

                } else {
                    out.print(i + " ");
                }
            }
            out.println();
        }
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        int count;
        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    private static class Diff {
        int x;
        int y;
        public Diff(int x, int y) {
            this.x = x;
            this.y = y;
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