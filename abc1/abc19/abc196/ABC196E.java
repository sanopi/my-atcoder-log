import java.io.PrintWriter;
import java.util.Scanner;

public class ABC196E {

    public static void main(String[] args) {
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nextInt(), nextInt());
        }

        long add = 0;
        long max = 2000000000000000L;
        long min = -2000000000000000L;

        for (int i = 0; i < n; i++) {
            Pair pair = pairs[i];
            int a = pair.a;
            int t = pair.t;
            if (t == 1) {
                add+=a;
                max+=a;
                min+=a;
            } else if (t == 2) {
                max = Math.max(max, a);
                min = Math.max(min, a);
            } else if (t == 3) {
                max = Math.min(max, a);
                min = Math.min(min, a);
            }
        }


        int q = nextInt();
        while (q-- > 0) {
            long x = nextInt();
            long ans = x + add;
            if (ans < min) ans = min;
            if (max < ans) ans = max;
            out.println(ans);
        }

        out.flush();
    }

    private static final class Pair {
        int a;
        int t;
        public Pair(int a, int t) {
            this.a = a;
            this.t = t;
        }
    }

    private static final class Range {
        long min;
        long max;
        Op op;
        public Range(long min, long max, Op op) {
            this.min = min;
            this.max = max;
            this.op = op;
        }
    }

    private static final class Op {
        long num;
        // 1なら足し算、2なら固定値
        int op;
        public Op(long num, int op) {
            this.num = num;
            this.op = op;
        }
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