import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q63_MonochromaticSubgrid_4 {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[][] g = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                g[i][j] = nextInt();
            }
        }

        int ans = 0;
        for (int i = 1; i < 1<<h; i++) {
            List<Integer> lines = new ArrayList<>(h);
            for (int j = 0; j < h; j++) {
                if ((i & (1<<j)) != 0) {
                    lines.add(j);
                }
            }
            List<Integer> commons = new ArrayList<>();
            for (int j = 0; j < w; j++) {
                int p = g[lines.get(0)][j];
                boolean allSame = true;
                for (int k = 1; k < lines.size(); k++) {
                    allSame = allSame && p == g[lines.get(k)][j];
                }
                if (allSame) {
                    commons.add(p);
                }
            }

            Map<Integer, Integer> counts = new HashMap<>();
            int max = 0;
            for (int j = 0; j < commons.size(); j++) {
                Integer p = commons.get(j);
                Integer count = counts.getOrDefault(p, 0);
                counts.put(p, count+1);
                max = Math.max(max, count+1);
            }
            ans = Math.max(ans, max * lines.size());
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}