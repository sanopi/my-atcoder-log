import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ABC277C {

    public static void main(String[] args) {
        int n = nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            List<Integer> l1 = map.getOrDefault(a, new ArrayList<>());
            l1.add(b);
            map.put(a, l1);
            List<Integer> l2 = map.getOrDefault(b, new ArrayList<>());
            l2.add(a);
            map.put(b, l2);
        }

        int ans = 1;
        Set<Integer> done = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        done.add(1);
        while (!q.isEmpty()) {
            Integer current = q.poll();
            for (Integer next : map.getOrDefault(current, List.of())) {
                if (done.contains(next)) continue;
                done.add(next);
                ans = Math.max(ans, next);
                q.add(next);
            }
        }
        out.println(ans);
        out.flush();
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