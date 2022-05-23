import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ABC223E {

    public static void main(String[] args) {
        int x = nextInt();
        int y = nextInt();
        long a = nextLong();
        long b = nextLong();
        long c = nextLong();
        long[] array = {a, b, c};
        boolean ok = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i==j) continue;
                for (int k = 0; k < 3; k++) {
                    if (i==k||j==k) continue;
                    Queue<Long> q = new ArrayDeque<>();
                    q.add(array[i]);
                    q.add(array[j]);
                    q.add(array[k]);
                    ok |= isOK(x, y, q);
                }
            }
        }
        out.println(ok?"Yes":"No");
        out.flush();
    }

    private static boolean isOK(long x, long y, Queue<Long> q) {
        if (x<0 || y<0) return false;
        if (q.isEmpty()) return true;
        if (x==0 || y == 0) return false;

        Long area = q.poll();
        List<Long> l = new ArrayList<>(q);
        Queue<Long> q1 = new ArrayDeque<>(l);
        Queue<Long> q2 = new ArrayDeque<>(l);

        return isOK(x-(area+y-1)/y, y, q1)
            || isOK(x, y-(area+x-1)/x, q2);
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