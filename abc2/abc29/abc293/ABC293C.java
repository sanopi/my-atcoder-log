import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC293C {

    private static final int[] X = {1, 0};
    private static final int[] Y = {0, 1};

    private static int h;
    private static int w;
    private static int[][] a;
    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        a = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = nextInt();
            }
        }
        int ans = dfs(0, 0, new HashSet<>(Set.of(a[0][0])));
        out.println(ans);
        out.flush();
    }

    private static int dfs(int cx, int cy, Set<Integer> done) {
        if (cx == h-1 && cy == w-1) {
            if (done.size() == (h+w-1)) {
                return 1;
            } else {
                return 0;
            }
        }

        int res = 0;
        for (int i = 0; i < 2; i++) {
            int nx = cx+X[i];
            int ny = cy+Y[i];
            if (nx<h && ny<w) {
                int val = a[nx][ny];
                if (done.contains(val)) continue;
                done.add(val);
                res += dfs(nx, ny, done);
                done.remove(val);
            }
        }
        return res;
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