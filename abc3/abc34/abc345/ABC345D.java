import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC345D {

    private static char[][] current;
    private static int h;
    private static int w;
    private static Tile[] tiles;

    private static void solve() {
        int n = nextInt();
        h = nextInt();
        w = nextInt();
        tiles = new Tile[n];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            tiles[i] = new Tile(a, b);
        }
        current = new char[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(current[i], 'x');
        }
        Set<Integer> set = IntStream.range(0, n).boxed().collect(Collectors.toSet());
        boolean result = rec(set);
        out.println(result ? "Yes" : "No");
        out.flush();
    }

    private static boolean rec(Set<Integer> rest) {
//        for (char[] chars : current) {
//            System.out.println(Arrays.toString(chars));
//        }
//        System.out.println();
        {
            boolean ok = true;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (current[i][j] == 'x') {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                return true;
            }
        }

        char[][] memo = new char[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                memo[i][j] = current[i][j];
            }
        }

        int ii = -1;
        int jj = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (current[i][j] == 'x') {
                    ii = i;
                    jj = j;
                    break;
                }
            }
            if (ii!=-1) break;
        }
        boolean res = false;
        for (Integer num : rest) {
            Tile ti = tiles[num];
            HashSet<Integer> copy = new HashSet<>();
            for (Integer j : rest) {
                if (num.equals(j)) continue;
                copy.add(j);
            }
            if (ii+ti.a <= h && jj+ti.b <= w) {
                boolean ok = true;
                for (int iii = ii; iii < ii + ti.a; iii++) {
                    for (int jjj = jj; jjj < jj + ti.b; jjj++) {
                        if (current[iii][jjj] == 'o') {
                            ok = false;
                            break;
                        }
                        current[iii][jjj] = 'o';
                    }
                    if (!ok) break;
                }
                if (ok) {
                    res |= rec(copy);
                }
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        current[i][j] = memo[i][j];
                    }
                }
            }
            if (ii+ti.b <= h && jj+ti.a <= w) {
                boolean ok = true;
                for (int iii = ii; iii < ii + ti.b; iii++) {
                    for (int jjj = jj; jjj < jj + ti.a; jjj++) {
                        if (current[iii][jjj] == 'o') {
                            ok = false;
                            break;
                        }
                        current[iii][jjj] = 'o';
                    }
                    if (!ok) break;
                }
                if (ok) {
                    res |= rec(copy);
                }

                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        current[i][j] = memo[i][j];
                    }
                }
            }
        }
        return res;
    }

    private static class Tile {
        int a;
        int b;
        public Tile(int a, int b) {
            this.a = a;
            this.b = b;
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