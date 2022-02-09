import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ABC049C {

    public static void main(String[] args) {
        String s = next();
        String dream = "dream";
        String dreamer = "dreamer";
        String erase = "erase";
        String eraser = "eraser";
        String dreamerase = "dreamerase";
        String dreameraser = "dreameraser";
        List<String> strings = List.of(
            dreameraser,
            dreamerase,
            dreamer,
            dream,
            eraser,
            erase
        );
        int index = 0;
        while (index < s.length()) {
            int finalIndex = index;
            Optional<String> hit = strings.stream().
                filter(candidates -> s.startsWith(candidates, finalIndex))
                .findFirst();
            if (hit.isEmpty()) {
                break;
            }
            index+=hit.orElseThrow().length();
        }
        out.println(index == s.length() ? "YES" : "NO");
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