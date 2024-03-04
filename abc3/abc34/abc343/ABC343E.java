import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ABC343E {

    private static void solve() {
        int v1 = nextInt();
        int v2 = nextInt();
        int v3 = nextInt();
        int a1 = 0;
        int b1 = 0;
        int c1 = 0;
        for (int a2 = -7; a2 <= 7; a2++) {
            for (int b2 = -7; b2 <= 7; b2++) {
                for (int c2 = -7; c2 <= 7; c2++) {
                    for (int a3 = Math.min(a1, a2)-7; a3 <= Math.max(a1, a2) + 7; a3++) {
                        for (int b3 = Math.min(b1, b2)-7; b3 <= Math.max(b1, b2) + 7; b3++) {
                            for (int c3 = Math.min(c1, c2)-7; c3 <= Math.max(c1, c2) + 7; c3++) {
                                Range a1Range = new Range(a1, a1 + 7);
                                Range a2Range = new Range(a2, a2 + 7);
                                Range a3Range = new Range(a3, a3 + 7);
                                Range b1Range = new Range(b1, b1 + 7);
                                Range b2Range = new Range(b2, b2 + 7);
                                Range b3Range = new Range(b3, b3 + 7);
                                Range c1Range = new Range(c1, c1 + 7);
                                Range c2Range = new Range(c2, c2 + 7);
                                Range c3Range = new Range(c3, c3 + 7);

                                int t1 = 7*7*7 * 3;
                                int t2 = a1Range.calc(a2Range).getLen() * b1Range.calc(b2Range).getLen() * c1Range.calc(c2Range).getLen()
                                    + a1Range.calc(a3Range).getLen() * b1Range.calc(b3Range).getLen() * c1Range.calc(c3Range).getLen()
                                    + a2Range.calc(a3Range).getLen() * b2Range.calc(b3Range).getLen() * c2Range.calc(c3Range).getLen();
                                int t3 = a1Range.calc(a2Range).calc(a3Range).getLen() * b1Range.calc(b2Range).calc(b3Range).getLen() * c1Range.calc(c2Range).calc(c3Range).getLen();
                                t1 -= t3*3;
                                t2 -= t3*3;
                                t1 -= t2*2;

                                if (t1 == v1 && t2 == v2 && t3 == v3) {
                                    System.out.println("Yes");
                                    System.out.printf("%d %d %d %d %d %d %d %d %d", a1, b1, c1, a2, b2, c2, a3, b3, c3);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("No");
    }

    private static class Range {
        int l;
        int r;
        public Range(int l, int r) {
            this.l = l;
            this.r = r;
        }
        private Range calc(Range other) {
            int ll = Math.max(this.l, other.l);
            int rr = Math.min(this.r, other.r);
            if (rr <= ll) {
                return new Range(0, 0);
            } else {
                return new Range(ll, rr);
            }
        }

        private int getLen() {
            return r-l;
        }
    }

    private static class P {
        Map<Integer, Integer> map = new HashMap<>();
        public P(int a, int b, int c) {
            map.merge(a, 1, Math::addExact);
            map.merge(b, 1, Math::addExact);
            map.merge(c, 1, Math::addExact);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            P p = (P) o;
            return Objects.equals(map, p.map);
        }
        @Override
        public int hashCode() {
            return Objects.hash(map);
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