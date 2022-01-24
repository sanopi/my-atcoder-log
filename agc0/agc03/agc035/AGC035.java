import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AGC035 {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        Map<Integer, Integer> intCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            intCount.put(a[i], intCount.getOrDefault(a[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> counts = intCount.entrySet().stream()
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toList());

        if (counts.size() == 1 && counts.get(0).getKey() == 0) {
            System.out.println("Yes");
            return;
        }
        if (counts.size() == 2 && counts.get(0).getKey() == 0 && counts.get(1).getValue() * 3 == n*2) {
            System.out.println("Yes");
            return;
        }

        if (counts.size() == 3 && counts.get(0).getValue() *3 == n && counts.get(1).getValue() *3 == n && counts.get(2).getValue() *3 == n && (counts.get(0).getKey() ^ counts.get(1).getKey()) == counts.get(2).getKey()) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
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