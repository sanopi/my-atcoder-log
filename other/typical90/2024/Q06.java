import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q06 {

    private static void solve() {
        int n = nextInt();
        int k = nextInt();
        String s = next();
        char[] chars = s.toCharArray();
        Queue<Integer>[] queues = new Queue[26];
        for (int i = 0; i < 26; i++) {
            queues[i] = new ArrayDeque<>();
        }
        for (int i = 0; i < n; i++) {
            char si = chars[i];
            queues[si-'a'].add(i);
        }

        int current = 0;
        StringBuilder ans = new StringBuilder();
        while (current < n && k > 0) {
            for (int i = 0; i < 26; i++) {
                Queue<Integer> queue = queues[i];
                boolean filled = false;
                while (!queue.isEmpty()) {
                    Integer found = queue.peek();
                    if (found < current) {
                        queue.poll();
                        continue;
                    }
                    if (n-found<k) break;
                    k--;
                    current = found+1;
                    ans.append((char)(i+'a'));
                    filled = true;
                    break;
                }
                if (filled) break;
            }
        }

        if (k == 0) {
            out.println(ans);
        } else {
            throw new RuntimeException();
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