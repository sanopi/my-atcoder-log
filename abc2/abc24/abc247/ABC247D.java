import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC247D {

    public static void main(String[] args) {
        int q = nextInt();
        Deque<Pair> deque = new ArrayDeque<>();
        while (q-->0) {
            int num = nextInt();
            if (num == 1) {
                int x = nextInt();
                int c = nextInt();
                deque.addLast(new Pair(x, c));
            } else {
                int c = nextInt();
                long ans = 0;
                while (c>0) {
                    Pair current = deque.pollFirst();
                    int count = Math.min(c, current.count);
                    ans += (long) current.x * count;
                    current.count -= count;
                    if (current.count>0) {
                        deque.addFirst(current);
                    }
                    c -= count;
                }
                out.println(ans);
            }
        }
        out.flush();
    }

    private static class Pair {
        int x;
        int count;
        public Pair(int x, int count) {
            this.x = x;
            this.count = count;
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