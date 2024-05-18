import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ABC347E {

    private static void solve() {
        int n = nextInt();
        int q = nextInt();

        Set<Integer> set = new HashSet<>();
        long[] sizeSum = new long[q+1];

        Queue<Integer>[] queues = new Queue[n];
        for (int i = 0; i < n; i++) {
            queues[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < q; i++) {
            int x = nextInt()-1;
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
            sizeSum[i+1] = set.size();
            queues[x].add(i);
        }
        for (int i = 0; i < q; i++) {
            sizeSum[i+1] += sizeSum[i];
        }
        for (int i = 0; i < n; i++) {
            long ans = 0;
            Queue<Integer> queue = queues[i];
            while (queue.size() >= 2) {
                Integer start = queue.poll();
                Integer end = queue.poll();
                ans += sizeSum[end]-sizeSum[start];
            }
            if (queue.size() == 1) {
                Integer start = queue.poll();
                ans += sizeSum[q] - sizeSum[start];
            }
            out.print(ans+" ");
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