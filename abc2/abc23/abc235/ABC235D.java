import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ABC235D {

    public static void main(String[] args) {
        long a = nextInt();
        long n = nextInt();

        Set<Long> done = new HashSet<>();
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(1, 0));
        done.add(1L);
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair current = q.poll();
            long i = current.i;
            int count = current.count;
            if (i == n) {
                ans = Math.min(ans, count);
                continue;
            }
            if (Long.toString(i).length() > Long.toString(n).length()) {
                continue;
            }
            if (i >= 10 && i%10 != 0) {
                String s = Long.toString(i);
                Long rotated = Long.parseLong(s.substring(s.length() - 1) + s.substring(0, s.length() - 1));
                if (!done.contains(rotated)) {
                    done.add(rotated);
                    q.add(new Pair(rotated, count+1));
                }
            }
            long next = i*a;
            if (!done.contains(next)) {
                done.add(next);
                q.add(new Pair(next, count+1));
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        out.flush();
    }

    private static class Pair {
        long i;
        int count;
        public Pair(long i, int count) {
            this.i = i;
            this.count = count;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "i=" + i +
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