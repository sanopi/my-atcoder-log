import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ABC335D {

    private static final Map<Character, Character> NEXT_D = Map.of(
        'R', 'D',
        'D', 'L',
        'L', 'U',
        'U', 'R'
    );
    private static final Map<Character, Integer> NEXT_I = Map.of(
        'R', 1,
        'D', 0,
        'L', -1,
        'U', 0
    );
    private static final Map<Character, Integer> NEXT_J = Map.of(
        'R', 0,
        'D', 1,
        'L', 0,
        'U', -1
    );

    private static void solve() {
        int n = nextInt();
        int[][] ans = new int[n][n];
        Queue<P> q = new ArrayDeque<>();
        q.add(new P(0, 0, 'R', 1));
        ans[0][0] = 1;
        while (!q.isEmpty()) {
            P current = q.poll();
            int ci = current.i;
            int cj = current.j;
            char cd = current.d;
            int nn = current.num + 1;
            int ni = ci + NEXT_I.get(cd);
            int nj = cj + NEXT_J.get(cd);
            char nd = cd;
            if (
                !(0<=ni && ni < n && 0<=nj && nj < n)
                || ans[ni][nj] != 0
            ) {
                nd = NEXT_D.get(cd);
                ni = ci + NEXT_I.get(nd);
                nj = cj + NEXT_J.get(nd);
            }
            ans[ni][nj] = nn;
            if (ans[ni][nj] == n*n-1) break;
            q.add(new P(ni, nj, nd, nn));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n/2 && j == n/2) {
                    out.print("T ");
                } else {
                    out.print(ans[i][j]+" ");
                }
            }
            out.println();
        }
        out.flush();
    }

    private static class P {
        int i;
        int j;
        char d;
        int num;
        public P(int i, int j, char d, int num) {
            this.i = i;
            this.j = j;
            this.d = d;
            this.num = num;
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