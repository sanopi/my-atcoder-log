import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC233C {

    private static int n;
    public static void main(String[] args) {
        n = nextInt();
        long x = nextLong();
        List<Integer>[] bags = new List[n];
        for (int i = 0; i < n; i++) {
            bags[i] = new ArrayList<>();
            int l = nextInt();
            for (int j = 0; j < l; j++) {
                bags[i].add(nextInt());
            }
        }

        List<Long> kouho = new ArrayList<>();
        kouho.add(1L);
        for (int i = 0; i < n; i++) {
            List<Integer> balls = bags[i];
            List<Long> result = new ArrayList<>();
            for (Long l : kouho) {
                for (Integer ball : balls) {
                    if (l*ball>=l) {
                        result.add(l*ball);
                    }
                }
            }
            kouho = result;
        }
        out.println(kouho.stream().filter(l -> l.equals(x)).count());
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