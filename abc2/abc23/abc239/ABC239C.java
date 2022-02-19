import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ABC239C {

    private static int[] nextX = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] nextY = {2, 1, -1, -2, -2, -1, 1 , 2};

    public static void main(String[] args) {
        int x1 = nextInt();
        int y1 = nextInt();
        int x2 = nextInt();
        int y2 = nextInt();

        Set<Pair> set1 = make(x1, y1);
        Set<Pair> set2 = make(x2, y2);
        out.println(set1.stream().anyMatch(p -> set2.contains(p)) ? "Yes" : "No");

        out.flush();
    }

    private static Set<Pair> make(int x, int y) {
        return IntStream.range(0, 8)
            .mapToObj(i -> new Pair(x + nextX[i], y + nextY[i]))
            .collect(Collectors.toSet());
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

            if (x != pair.x) return false;
            return y == pair.y;
        }
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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