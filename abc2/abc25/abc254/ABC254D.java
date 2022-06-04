import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC254D {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Integer, Integer>[] maps = new Map[n+1];
        for (int i = 0; i < n + 1; i++) {
            maps[i] = new HashMap<>();
        }

        for (int i = 2; i < n + 1; i++) {
            if (!maps[i].isEmpty()) continue;
            for (long j = i; j < n + 1; j*=i) {
                for (long k = j; k < n + 1; k+=j) {
                    Map<Integer, Integer> map = maps[(int)k];
                    map.put(i, (map.getOrDefault(i, 0)+1)%2);
                }
            }
        }

        int[] counts = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            Map<Integer, Integer> map = maps[i];
            int result = map.entrySet().stream()
                .filter(entry -> entry.getValue() != 0)
                .mapToInt(entry -> entry.getKey())
                .reduce(1, Math::multiplyExact);
            counts[result]++;
        }

        long ans = 0;
        for (int i = 1; i < n + 1; i++) {
            int count = counts[i];
            ans += (long)count*(count);
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