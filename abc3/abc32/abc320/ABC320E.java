import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC320E {

    private static void solve() {
        int n = nextInt();
        int m = nextInt();
        int[] t = new int[m];
        long[] w = new long[m];
        int[] s = new int[m];
        for (int i = 0; i < m; i++) {
            int ti = nextInt();
            int wi = nextInt();
            int si = nextInt();
            t[i] =ti;
            w[i] = wi;
            s[i] = si;
        }
        PriorityQueue<Outside> outsides = new PriorityQueue<>(Comparator.comparing(outside -> outside.s));
        PriorityQueue<Integer> isIn = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            isIn.add(i);
        }
        long[] ans = new long[n];

        for (int i = 0; i < m; i++) {
            int ti = t[i];
            long wi = w[i];
            int si = s[i];
            while (!outsides.isEmpty() && outsides.peek().s <= ti) {
                Outside outside = outsides.poll();
                isIn.add(outside.i);
            }
            if (isIn.isEmpty()) continue;
            Integer first = isIn.poll();
            ans[first] += wi;
            outsides.add(new Outside(first, ti+si));
        }
        for (long an : ans) {
            out.println(an);
        }

        out.flush();
    }

    private static class Outside {
        int i;
        int s;
        public Outside(int i, int s) {
            this.i = i;
            this.s = s;
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