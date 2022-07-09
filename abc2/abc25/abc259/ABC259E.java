import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class ABC259E {

    public static void main(String[] args) {
        int n = nextInt();
        List<PE>[] input = new List[n];
        for (int i = 0; i < n; i++) {
            input[i] = new ArrayList<>();
        }
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int m = nextInt();
            for (int j = 0; j < m; j++) {
                int p = nextInt();
                int e = nextInt();
                input[i].add(new PE(p, e));
                Pair pair = map.getOrDefault(p, new Pair(0, 0));
                if (e > pair.e) {
                    map.put(p, new Pair(e, 1));
                } else if (e == pair.e) {
                    pair.count++;
                    map.put(p, pair);
                }
            }
        }

        Set<Set<PE>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            List<PE> list = input[i];
            Set<PE> tmp = new HashSet<>();
            for (PE pe : list) {
                Pair pair = map.get(pe.p);
                if (pair.e == pe.e && pair.count == 1) {
                    tmp.add(pe);
                }
            }
            set.add(tmp);
        }
        out.println(set.size());
        out.flush();
    }

    private static class Pair {
        int e;
        int count;
        public Pair(int e, int count) {
            this.e = e;
            this.count = count;
        }
    }

    private static class PE {
        int p;
        int e;
        public PE(int p, int e) {
            this.p = p;
            this.e = e;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PE pe = (PE) o;
            return p == pe.p && e == pe.e;
        }
        @Override
        public int hashCode() {
            return Objects.hash(p, e);
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