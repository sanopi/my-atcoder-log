import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class AGC032A {

    public static void main(String[] args) {
        int n = nextInt();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            b.add(nextInt()-1);
        }
        Deque<Integer> ans = new ArrayDeque<>();

        while (b.size()>0) {
            int size = b.size();
            for (int i = b.size() - 1; i >= 0; i--) {
                if (b.get(i) == i) {
                    b.remove(i);
                    ans.addFirst(i+1);
                    break;
                }
            }
            if (size == b.size()) {
                System.out.println(-1);
                return;
            }
        }
        ans.forEach(out::println);
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