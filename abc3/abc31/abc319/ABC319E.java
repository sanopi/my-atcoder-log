import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC319E {

    private static BusStop[] busStops;
    private static int n;
    private static long y;
    private static void solve() {
        n = nextInt();
        long x = nextLong();
        y = nextLong();
        busStops = new BusStop[n-1];
        for (int i = 0; i < n-1; i++) {
            int p = nextInt();
            long t = nextLong();
            busStops[i] = new BusStop(p, t);
        }
        int total = 8 * 7 * 6 * 5 * 4 * 3 * 2;
        Map<Point, Long> memo = new HashMap<>();
        for (int i = 0; i < total; i++) {
            long ni = (i+x);
            int[] newOnGoing = new int[9];
            for (int j = 2; j < 9; j++) {
                newOnGoing[j] = (int)(ni%j);
            }
            Point point = new Point(newOnGoing);
            if (memo.containsKey(point)) continue;
            long result = dfs(0, point);
            memo.put(point, result);
        }

        int q = nextInt();
        while (q --> 0) {
            long qi = nextLong();
            int[] newOnGoing = new int[9];
            for (int j = 2; j < 9; j++) {
                newOnGoing[j] = (int) ((qi+x)%j);
            }
            Point point = new Point(newOnGoing);
            Long result = memo.get(point);
            out.println(result+qi+x);
        }
        out.flush();
    }

    private static long dfs(int current, Point point) {
        if (current == n-1) {
            return y;
        }

        BusStop busStop = busStops[current];
        int rest = (busStop.p - point.onGoing[busStop.p])% busStop.p;
        long add = rest + busStop.t;
        int[] newOnGoing = new int[9];
        for (int i = 2; i < 9; i++) {
            newOnGoing[i] = (int) ((point.onGoing[i] + add)%i);
        }
        long res = dfs(current+1, new Point(newOnGoing));

        return res+add;
    }

    private static class BusStop {
        int p;
        long t;
        public BusStop(int p, long t) {
            this.p = p;
            this.t = t;
        }
        @Override
        public String toString() {
            return "BusStop{" +
                "p=" + p +
                ", t=" + t +
                '}';
        }
    }

    private static class Point {
        int[] onGoing = new int[9];
        public Point(int[] onGoing) {
            this.onGoing = onGoing;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Arrays.equals(onGoing, point.onGoing);
        }
        @Override
        public int hashCode() {
            return Arrays.hashCode(onGoing);
        }
        @Override
        public String toString() {
            return "Point{" +
                "onGoing=" + Arrays.toString(onGoing) +
                '}';
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