import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC335C {

    private static void solve() {
        int n = nextInt();
        int q = nextInt();
        List<P> history = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            history.add(new P(i, 0));
        }
        while (q --> 0) {
            int t = nextInt();
            if (t == 1) {
                String c = next();
                history.add(history.get(history.size()-1).move(c));
            } else {
                int p = nextInt();
                P target = history.get(history.size() - p);
                out.println(target+" ");
            }
        }
        out.flush();
    }

    private static class P {
        int x;
        int y;
        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private P move(String c) {
            return switch (c) {
                case "R" -> new P(x+1, y);
                case "L" -> new P(x-1, y);
                case "U" -> new P(x, y+1);
                case "D" -> new P(x, y-1);
                default -> throw new RuntimeException();
            };
        }
        @Override
        public String toString() {
            return x + " " + y;
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