import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC259C {

    public static void main(String[] args) {
        String s = next();
        String t = next();

        Deque<Pair> ss = asshuku(s);
        Deque<Pair> tt = asshuku(t);

        while (!ss.isEmpty() && !tt.isEmpty()) {
            Pair sf = ss.pollFirst();
            Pair tf = tt.pollFirst();
            if (sf.c != tf.c) {
                System.out.println("No");
                return;
            }
            if (sf.count > tf.count || (sf.count==1 && tf.count>1)) {
                System.out.println("No");
                return;
            }
        }
        if (!ss.isEmpty() || !tt.isEmpty()) {
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
    }


    private static Deque<Pair> asshuku(String s) {
        Deque<Pair> ss = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (ss.isEmpty()) {
                ss.add(new Pair(c, 1));
            } else {
                Pair last = ss.pollLast();
                if (last.c == c) {
                    last.count++;
                    ss.add(last);
                } else {
                    ss.add(last);
                    ss.add(new Pair(c, 1));
                }
            }
        }
        return ss;
    }

    private static class Pair {
        char c;
        int count;
        public Pair(char c, int count) {
            this.c = c;
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