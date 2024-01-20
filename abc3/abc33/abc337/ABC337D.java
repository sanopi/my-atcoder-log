import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class ABC337D {

    private static final Map<Character, Integer> map = Map.of(
        'o', 0,
        'x', 1,
        '.', 2
    );

    private static void solve() {
        int h = nextInt();
        int w = nextInt();
        int k = nextInt();
        char[][] chars = new char[h][w];
        for (int i = 0; i < h; i++) {
            chars[i] = next().toCharArray();
        }
        char[][] chars2 = new char[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                chars2[j][i] = chars[i][j];
            }
        }

        int result1 = calc(h, w, chars, k);
        int result2 = calc(w, h, chars2, k);
        int ans = Math.min(result1, result2);
        if (ans == Integer.MAX_VALUE) {
            out.println(-1);
        } else out.println(ans);
        out.flush();
    }

    private static int calc(int h, int w, char[][] chars, int k) {
        if (w < k) return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < h; i++) {
            int[] counts = new int[3];
            for (int j = 0; j < k; j++) {
                counts[map.get(chars[i][j])]++;
            }
            if (counts[1] == 0) res = Math.min(res, counts[2]);
            for (int j = k; j < w; j++) {
                counts[map.get(chars[i][j])]++;
                counts[map.get(chars[i][j-k])]--;
                if (counts[1] == 0) res = Math.min(res, counts[2]);
            }
        }
        return res;
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