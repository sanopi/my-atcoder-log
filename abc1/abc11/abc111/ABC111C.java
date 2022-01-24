import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC111C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] v = nextIntArray(n);
        Map<Integer, Integer> countsE = new HashMap<>();
        Map<Integer, Integer> countsO = new HashMap<>();
        for (int i = 0; i < n; i++) {
            countsE.put(v[i], countsE.getOrDefault(v[i], 0)+1);
            i++;
            countsO.put(v[i], countsO.getOrDefault(v[i], 0)+1);
        }
        int ans = Integer.MAX_VALUE;
        List<Map.Entry<Integer, Integer>> es = countsE.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getValue())).limit(2).collect(Collectors.toList());
        List<Map.Entry<Integer, Integer>> os = countsO.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getValue())).limit(2).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> e : es) {
            for (Map.Entry<Integer, Integer> o : os) {
                if (e.getKey().equals(o.getKey())) {
                    continue;
                }
                ans = Math.min(ans, n-e.getValue()-o.getValue());
            }
        }
        if (ans == Integer.MAX_VALUE) {
            ans = n/2;
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