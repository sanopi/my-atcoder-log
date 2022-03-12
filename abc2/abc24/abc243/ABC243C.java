import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC243C {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            List<Pair> list = map.getOrDefault(y, new ArrayList<>());
            list.add(new Pair(x, i));
            map.put(y, list);
        }
        String s = next();

        boolean ok = map.values().stream()
            .anyMatch(list -> {
                String s1 = list.stream()
                    .sorted(Comparator.comparing(p -> p.x))
                    .map(p -> s.charAt(p.i))
                    .map(c -> String.valueOf(c))
                    .collect(Collectors.joining());
                return s1.contains("R") && s1.contains("L") && s1.indexOf("R") < s1.lastIndexOf("L");
            });
        out.println(ok?"Yes":"No");
        out.flush();
    }

    private static class Pair {
        int x;
        int i;
        public Pair(int x, int i) {
            this.x = x;
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