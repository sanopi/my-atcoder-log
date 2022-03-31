import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC240D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Deque<ICount> dq = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            if (dq.isEmpty()) {
                dq.add(new ICount(ai, 1));
                count++;
            } else {
                ICount last = dq.pollLast();
                count-=last.count;
                if (last.i == ai) {
                    last.count++;
                    if (last.count!=last.i) {
                        dq.add(last);
                        count+=last.count;
                    }
                } else {
                    dq.add(last);
                    dq.add(new ICount(ai, 1));
                    count+=last.count;
                    count+=1;
                }
            }
            out.println(count);
        }
        out.flush();
    }

    private static class ICount {
        int i;
        int count;
        public ICount(int i, int count) {
            this.i = i;
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