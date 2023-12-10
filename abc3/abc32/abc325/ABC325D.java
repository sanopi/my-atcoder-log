import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC325D {

    private static void solve() {
        int n = nextInt();
        TreeMap<Long, List<Long>> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long t = nextLong();
            long d = nextLong();
            List<Long> list = treeMap.getOrDefault(t, new ArrayList<>());
            list.add(t+d);
            treeMap.put(t, list);
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long time = 0;
        int ans = 0;
        while (!treeMap.isEmpty() || !pq.isEmpty()) {
            if (pq.isEmpty() || (!treeMap.isEmpty() && time == treeMap.firstKey())) {
                Map.Entry<Long, List<Long>> first = treeMap.pollFirstEntry();
                pq.addAll(first.getValue());
                time = first.getKey();
            } else {
                Long d = pq.poll();
                if (time <= d) {
                    ans++;
                    time++;
                }
            }
        }

        out.println(ans);
        out.flush();
    }



    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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