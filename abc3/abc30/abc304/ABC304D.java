import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC304D {

    public static void main(String[] args) {
        int w = nextInt();
        int h = nextInt();
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }
        int A = nextInt();
        TreeSet<Integer> a = new TreeSet<>();
        a.add(0);
        for (int i = 0; i < A; i++) {
            a.add(nextInt());
        }
        int B = nextInt();
        TreeSet<Integer> b = new TreeSet<>();
        b.add(0);
        for (int i = 0; i < B; i++) {
            b.add(nextInt());
        }

        Map<Pair, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(
                a.floor(pairs[i].x),
                b.floor(pairs[i].y)
                );
            count.merge(pair, 1, Math::addExact);
        }
        Integer max = count.values().stream().max(Comparator.naturalOrder()).get();
        Integer min;
        if (count.size() < (long)(A+1)*(B+1)) {
            min = 0;
        } else {
            min = count.values().stream().min(Comparator.naturalOrder()).get();
        }
        out.println(min+ " " + max);

        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        @Override
        public String toString() {
            return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
        }
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