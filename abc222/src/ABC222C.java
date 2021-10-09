import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC222C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();

        char[][] a = new char[2*n][m];
        for (int i = 0; i < 2*n; i++) {
            a[i] = next().toCharArray();
        }

        // wins[i] == j のとき、iはj勝
        int[] wins = new int[2*n];
        // rank[i] == j のとき、jはi位
        int[] rank = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            rank[i] = i;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2*n; j++) {
                int p1 = rank[j];
                int p2 = rank[++j];
                char c1 = a[p1][i];
                char c2 = a[p2][i];
                if (c1 == c2) {
                    // do nothing
                } else if (c1 == 'G' && c2 == 'C') {
                    wins[p1] += 1;
                } else if (c1 == 'G' && c2 == 'P') {
                    wins[p2] += 1;
                } else if (c1 == 'C' && c2 == 'G') {
                    wins[p2] += 1;
                } else if (c1 == 'C' && c2 == 'P') {
                    wins[p1] += 1;
                } else if (c1 == 'P' && c2 == 'G') {
                    wins[p1] += 1;
                } else if (c1 == 'P' && c2 == 'C') {
                    wins[p2] += 1;
                }
            }
            List<Pair> l = new ArrayList<>();
            for (int j = 0; j < 2*n; j++) {
                l.add(new Pair(j, wins[j]));
            }
            Comparator<Pair> comparing = Comparator.comparing(p -> -p.count);
            l.sort(comparing.thenComparing(p -> p.person));
            for (int j = 0; j < n * 2; j++) {
                rank[j] = l.get(j).person;
            }
        }
        for (final int i : rank) {
            out.println(i+1);
        }
        out.flush();
    }

    private static class Pair {
        int person;
        int count;
        public Pair(final int person, final int count) {
            this.person = person;
            this.count = count;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "person=" + person +
                ", count=" + count +
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