import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC311C {

    private static int[] a;
    private static boolean[] reached;
    private static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) {
        int n = nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt()-1;
        }
        reached = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!reached[i]) {
                solve(i, new HashSet<>());
                if (!ans.isEmpty()) {
                    break;
                }
            }
        }
        out.println(ans.size());
        for (int i = ans.size() - 1; i >= 0; i--) {
            out.print(ans.get(i)+1 + " ");
        }
        out.println();

        out.flush();
    }

    private static Integer solve(int current, Set<Integer> done) {
        reached[current] = true;
        done.add(current);

        int next = a[current];
        if (done.contains(next)) {
            ans.add(current);
            return next;
        }

        Integer res = solve(next, done);
        if (res == null) return null;
        ans.add(current);
        if (res == current) return null;
        return res;
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