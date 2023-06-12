import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC305F {

    private static final Set<Integer> done = new HashSet<>(100);

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        done.add(1);
//        solve1(1, 0);
        solve2();
    }

    private static void solve2() {
        Deque<Integer> history = new ArrayDeque<>();
        int current = 1;
        while (true) {
            String ks = next();
            if (ks.equals("OK")) {
                return;
            }
            int k = Integer.parseInt(ks);
            int[] v = new int[k];
            for (int i = 0; i < k; i++) {
                v[i] = nextInt();
            }
            boolean moved = false;
            for (int i = 0; i < k; i++) {
                int next = v[i];
                if (done.contains(next)) continue;
                done.add(next);
                System.out.println(next);
                history.addLast(current);
                current = next;
                moved = true;
                break;
            }
            if (!moved) {
                Integer next = history.pollLast();
                System.out.println(next);
                current = next;
            }
        }
    }

    private static boolean solve1(int current, int prev) {
        String ks = next();
        if (ks.equals("OK")) {
            return true;
        }
        int k = Integer.parseInt(ks);
        int[] v = new int[k];
        for (int i = 0; i < k; i++) {
            v[i] = nextInt();
        }
        for (int i = 0; i < k; i++) {
            int next = v[i];
            if (done.contains(next)) continue;
            done.add(next);
            System.out.println(next);
            if (solve1(next, current)) {
                return true;
            }
            int kk = nextInt();
            for (int i1 = 0; i1 < kk; i1++) {
                nextInt();
            }
        }

        System.out.println(prev);
        return false;
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