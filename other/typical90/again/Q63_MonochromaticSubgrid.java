package again;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Q63_MonochromaticSubgrid {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] P = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                P[i][j] = nextInt();
            }
        }

        long ans = 0;
        for (int i = 1; i < 1 << h; i++) {
            List<Integer> hs = new ArrayList<>();
            for (int j = 0; j < h; j++) {
                if ((i & 1<<j) != 0) {
                    hs.add(j);
                }
            }

            Map<Integer, Integer> counts = new HashMap<>();
            for (int j = 0; j < w; j++) {
                boolean ok = true;
                for (int k = 1; k < hs.size(); k++) {
                    ok &= P[hs.get(k)][j]==P[hs.get(k-1)][j];
                }
                if (ok) {
                    int p = P[hs.get(0)][j];
                    counts.put(p, counts.getOrDefault(p, 0) + hs.size());
                }
            }
            Optional<Integer> max = counts.values().stream().max(Comparator.naturalOrder());
            if (max.isPresent()) {
                ans = Math.max(ans, max.get());
            }
        }
        out.println(ans);
        out.flush();
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