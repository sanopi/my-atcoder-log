import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC243D {

    public static void main(String[] args) {
        int n = nextInt();
        long x = nextLong();
        char[] s = next().toCharArray();

        long minParent = x;
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (s[i] == 'U') {
                if (deque.isEmpty()) {
                    minParent = (minParent)/2;
                } else {
                    deque.pollLast();
                }
            } else if (s[i] == 'L') {
                deque.addLast('L');
            } else {
                deque.addLast('R');
            }
        }
        long ans = minParent;
        for (Character character : deque) {
            if (character == 'L') {
                ans = ans*2;
            } else {
                ans = ans*2+1;
            }
        }
        out.println(ans);
        out.flush();
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