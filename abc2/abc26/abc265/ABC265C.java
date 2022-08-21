import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class ABC265C {

    private static int h;
    private static int w;

    private static Map<Character, int[]> map = Map.of(
      'U', new int[]{-1, 0},
      'D', new int[]{1, 0},
      'L', new int[]{0, -1},
      'R', new int[]{0, 1}
    );

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        char[][] g = new char[h][w];
        for (int i = 0; i < h; i++) {
            g[i] = next().toCharArray();
        }
        P current = new P(0, 0);
        boolean[][] done = new boolean[h][w];
        done[0][0] = true;
        while (true) {
            int i = current.i;
            int j = current.j;
            char c = g[i][j];
            int[] ints = map.get(c);
            int ni = i + ints[0];
            int nj = j + ints[1];
            if(!(0<=ni && ni<h && 0 <= nj && nj<w)) {
                System.out.println((i+1) + " " + (j+1));
                return;
            }
            P next = new P(ni, nj);
            if (done[next.i][next.j]) {
                System.out.println(-1);
                return;
            }
            done[next.i][next.j] = true;
            current = next;
        }
    }

    private static class P {
        int i;
        int j;
        public P(int i, int j) {
            this.i = i;
            this.j = j;
        }
        @Override
        public String toString() {
            return "P{" +
                "i=" + i +
                ", j=" + j +
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