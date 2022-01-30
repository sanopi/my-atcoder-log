import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC237D {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

        Deque<String> deque = new ArrayDeque<>();
        deque.add(String.valueOf(n));
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'L') {
                deque.addLast(String.valueOf(i));
            } else {
                deque.addFirst(String.valueOf(i));
            }
        }

        deque.forEach(ss -> out.print(ss + " "));
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