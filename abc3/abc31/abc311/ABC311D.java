import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class ABC311D {

    private static int[] I = {0, 1, 0, -1};
    private static int[] J = {1, 0, -1, 0};

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = next().toCharArray();
        }

        boolean[][][] done = new boolean[n][m][4];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 1));
        done[1][1][0] = true;
        done[1][1][1] = true;
        done[1][1][2] = true;
        done[1][1][3] = true;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            done[current.i][current.j][0] = true;
            done[current.i][current.j][1] = true;
            done[current.i][current.j][2] = true;
            done[current.i][current.j][3] = true;
            for (int i = 0; i < 4; i++) {
                int ci = current.i;
                int cj = current.j;
                while (grid[ci+I[i]][cj+J[i]] == '.') {
                    ci+=I[i];
                    cj+=J[i];
                    if (done[ci][cj][i]) break;
                    done[ci][cj][i] = true;
                }
                if (grid[ci+I[i]][cj+J[i]] == '.') continue;
                boolean allDone = done[ci][cj][0] && done[ci][cj][1] && done[ci][cj][2] && done[ci][cj][3];
                if (!allDone) {
                    q.add(new Pair(ci, cj));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (done[i][j][0] || done[i][j][1] || done[i][j][2] || done[i][j][3]) {
                    ans++;
                }
            }
        }
        out.println(ans);
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