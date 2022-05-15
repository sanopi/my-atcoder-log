import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC251C {

    public static void main(String[] args) {
        int n = nextInt();
        Map<String, Submit> submits = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = next();
            int p = nextInt();
            if (!submits.containsKey(s)) {
                submits.put(s, new Submit(s, p, i));
            }
        }
        out.println(submits.values().stream().min(Comparator.comparing((Submit s) -> -s.p).thenComparing(s -> s.i)).get().i+1);

        out.flush();
    }

    private static class Submit {
        String s;
        int p;
        int i;
        public Submit(String s, int p, int i) {
            this.s = s;
            this.p = p;
            this.i = i;
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