import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC248E {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        if (k == 1) {
            System.out.println("Infinity");
            return;
        }

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) points[i] = new Point(nextInt(), nextInt());
        Set<Pair> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Point pi = points[i];
            Set<Integer> done = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                if (done.contains(j)) continue;

                Point pj = points[j];
                Pair pair = new Pair(i, j);
                int count = 2;
                for (int l = j+1; l < n; l++) {
                    Point pl = points[l];
                    if ((long)(pj.x-pi.x) * (pl.y-pi.y) == (long)(pl.x-pi.x) * (pj.y-pi.y)) {
                        done.add(l);
                        pair = new Pair(pair.b, l);
                        count++;
                    }
                }
                if (count>=k) {
                    ans.add(pair);
                }
            }
        }
        out.println(ans.size());
        out.flush();
    }

    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Pair {
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
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
        @Override
        public String toString() {
            return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
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