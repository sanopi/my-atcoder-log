import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ABC291C {

    private static final Map<Character, Pair> NEXT = Map.of(
        'R', new Pair(1, 0),
        'L', new Pair(-1, 0),
        'U', new Pair(0, 1),
        'D', new Pair(0, -1)
    );


    public static void main(String[] args) {
        int n = nextInt();
        char[] s = next().toCharArray();

        Set<Pair> done = new HashSet<>();
        Pair current = new Pair(0, 0);
        done.add(current);
        boolean ok = false;
        for (int i = 0; i < n; i++) {
            Pair add = NEXT.get(s[i]);
            Pair next = current.add(add);
            if (done.contains(next)) {
                ok = true;
                break;
            }
            current = next;
            done.add(current);
        }
        out.println(ok ? "Yes" : "No");
        out.flush();
    }

    private static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        private Pair add(Pair other) {
            return new Pair(this.x + other.x, this.y + other.y);
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