import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ABC060D {

    public static void main(String[] args) {
        int n = nextInt();
        int w = nextInt();
        Mono[] monos = new Mono[n];
        for (int i = 0; i < n; i++) {
            monos[i] = new Mono(nextInt(), nextInt());
        }

        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 0L);

        for (int i = 0; i < n; i++) {
            Mono mi = monos[i];
            Map<Integer, Long> newMap = new HashMap<>(map);
            Set<Integer> keys = map.keySet();
            for (Integer weight : keys) {
                int next = weight + mi.w;
                if (next <= w) {
                    newMap.put(next, Math.max(map.getOrDefault(next, 0L), map.get(weight) + mi.v));
                }
            }
            map = newMap;
        }
        out.println(map.values().stream().max(Comparator.naturalOrder()).get());
        out.flush();
    }

    private static class Mono {
        int w;
        int v;
        public Mono(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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