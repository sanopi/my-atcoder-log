import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ABC341C {

    private static final Map<Character, P> move = Map.of(
      'L', new P(0, -1),
      'R', new P(0, 1),
      'U', new P(-1, 0),
      'D', new P(1, 0)
    );

    private static void solve() {
        int h = nextInt();
        int w = nextInt();
        int n = nextInt();
        char[] t = next().toCharArray();
        char[][] s = new char[h][w];
        for (int i = 0; i < h; i++) {
            s[i] = next().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (s[i][j] == '#') continue;
                Queue<P> q = new ArrayDeque<>();
                q.add(new P(i, j));
                for (int k = 0; k < n; k++) {
                    P current = q.poll();
                    int ci = current.i;
                    int cj = current.j;
                    int ni = ci+move.get(t[k]).i;
                    int nj = cj+move.get(t[k]).j;
                    if (s[ni][nj] == '#') {
                        break;
                    }
                    q.add(new P(ni, nj));
                }
                if (!q.isEmpty()) {
                    ans++;
                }
            }
        }
        out.println(ans);
        out.flush();
    }

    private static class P {
        int i;
        int j;
        public P(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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