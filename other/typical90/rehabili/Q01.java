import java.io.PrintWriter;
import java.util.Scanner;

public class Q01 {

    private static void solve() {
        int n = nextInt();
        int l = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);
        int[] lengths = new int[n+1];
        lengths[0] = a[0];
        for (int i = 0; i < n-1; i++) {
            lengths[i+1] = a[i+1]-a[i];
        }
        lengths[n] = l-a[n-1];

        int ok = 1;
        int ng = l;
        while(ng-ok > 1) {
            int mid = (ok+ng)/2;
            // よくやるやり方やってみる
            {
                int count = 0;
                int sum = 0;
                for (int i = 0; i < n + 1; i++) {
                    sum+=lengths[i];
                    if (sum >= mid) {
                        count++;
                        sum = 0;
                    }
                }
                if (count >= k+1) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            }
            // Dequeでやってみる
//            {
//                Deque<Integer> deque = new ArrayDeque<>();
//                deque.addLast(0);
//                for (int i = 0; i < n + 1; i++) {
//                    Integer last = deque.pollLast();
//                    if (last < mid) {
//                        deque.addLast(last+lengths[i]);
//                    } else {
//                        deque.addLast(last);
//                        deque.addLast(lengths[i]);
//                    }
//                }
//                long count = deque.stream().filter(num -> num >= mid).count();
//                if (count >= k+1) {
//                    ok = mid;
//                } else {
//                    ng = mid;
//                }
//            }
        }
        out.println(ok);

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