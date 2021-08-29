import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ABC216D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Queue<Integer>[] a = new ArrayDeque[m];
        Deque<Integer> tubes = new ArrayDeque<>(m);
        for (int i = 0; i < m; i++) {
            int k = nextInt();
            a[i] = new ArrayDeque<>(k);
            for (int j = 0; j < k; j++) {
                a[i].add(nextInt()-1);
            }
            tubes.addLast(i);
        }

        Map<Integer, Integer> colTube = new HashMap<>();
        boolean[] done = new boolean[n];
        while (!tubes.isEmpty()) {
            int t = tubes.poll();
            Integer col = a[t].poll();
            if (col == null) {
                continue;
            }

            Integer tube = colTube.getOrDefault(col, null);
            if (tube == null) {
                colTube.put(col, t);
            } else {
                colTube.remove(col);
                done[col] = true;
                if (!a[t].isEmpty()) {
                    tubes.addFirst(t);
                }
                if (!a[tube].isEmpty()) {
                    tubes.addFirst(tube);
                }
            }
        }

        boolean ok = true;
        for (int i = 0; i < n; i++) {
            ok = ok && done[i];
        }
        out.println(ok ? "Yes" : "No");
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}