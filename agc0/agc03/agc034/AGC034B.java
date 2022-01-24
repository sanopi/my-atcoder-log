import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AGC034B {

    public static void main(String[] args) {
        String s = next();
        long count = 0;
        String[] split = s.replaceAll("BC", "D").split("[BC]");
        for (String ss : split) {
            if (ss.isBlank()) continue;
            List<Long> dIndice = new ArrayList<>();
            char[] chars = ss.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'D') dIndice.add(i+1L);
            }
            count += (dIndice.stream().reduce(0L,Math::addExact)-((long) (dIndice.size() + 1) *dIndice.size())/2);
        }
        out.println(count);
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