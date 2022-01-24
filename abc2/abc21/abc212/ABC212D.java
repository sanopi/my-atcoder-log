import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ABC212D {

    public static void main(String[] args) {
        int q = nextInt();
        PriorityQueue<Long> bag = new PriorityQueue<>();
        long sum = 0;

        for (int i = 0; i < q; i++) {
            int p = nextInt();
            if (p == 1) {
                long x = nextInt();
                bag.add(x - sum);
            } else if (p == 2) {
                long x = nextInt();
                sum += x;
            } else {
                Long poll = bag.poll();
                out.println(poll + sum);
            }
        }
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
}