import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ABC333E {

    private static void solve() {
        int n = nextInt();
        int[] t = new int[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = nextInt();
            x[i] = nextInt()-1;
        }
        int[] monsters = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            if (t[i] == 1) {
                if (monsters[x[i]] == 0) {
                    deque.addFirst(0);
                } else {
                    monsters[x[i]] -= 1;
                    deque.addFirst(1);
                }
            } else {
                monsters[x[i]] += 1;
            }
        }
        long count = Arrays.stream(monsters).filter(i -> i > 0).count();
        if (count != 0) {
            out.println(-1);
        } else {
            StringBuilder acts = new StringBuilder();
            int maxCnt = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (t[i] == 1) {
                    int take = deque.pollFirst();
                    if (take == 1) {
                        cnt += 1;
                    }
                    acts.append(take).append(" ");
                } else {
                    cnt -= 1;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }
            out.println(maxCnt);
            out.println(acts);
        }

        out.flush();
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