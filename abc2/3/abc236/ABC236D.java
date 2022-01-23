import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC236D {

    private static int[][] fun;
    private static int n;

    public static void main(String[] args) {
        n = nextInt();
        fun = new int[2 * n][2 * n];
        for (int i = 0; i < 2 * n; i++) {
            for (int j = i + 1; j < 2 * n; j++) {
                fun[i][j] = nextInt();
            }
        }
        System.out.println(calc(new HashSet<>(), new boolean[2 * n]));
    }

    private static int calc(Set<Pair> pairs, boolean[] done) {
        if (pairs.size() == n) {
            return pairs.stream().map(p -> fun[p.a][p.b]).reduce(0, (i, j) -> i ^ j);
        }
        int res = 0;
        int first = findFirst(done);
        done[first] = true;
        for (int i = 0; i < 2*n; i++) {
            if (done[i]) continue;
            done[i] = true;
            Pair pair = new Pair(first, i);
            pairs.add(pair);
            res = Math.max(res, calc(pairs, done));
            pairs.remove(pair);
            done[i] = false;
        }
        done[first] = false;
        return res;
    }

    private static int findFirst(boolean[] done) {
        for (int i = 0; i < done.length; i++) {
            if (!done[i]) {
                return i;
            }
        }
        return -1;
    }

    private static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = Math.min(a, b);
            this.b = Math.max(a, b);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;
        }
        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
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