import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC296E {

    private static int[] a;
    private static boolean[] done;
    public static void main(String[] args) {
        int n = nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt()-1;
        }
        done = new boolean[n];
        Set<Integer> inLoop = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (done[i]) continue;
            HashSet<Integer> app = new HashSet<>();
            HashSet<Integer> loop = new HashSet<>();
            dfs(i, app, loop);
            inLoop.addAll(loop);
        }
        out.println(inLoop.size());

        out.flush();
    }

    private static int dfs(int current, Set<Integer> app, Set<Integer> loop) {
        if (app.contains(current)) {
            loop.add(current);
            return current;
        }

        if (done[current]) {
            return -1;
        }
        done[current] = true;


        app.add(current);

        int next = a[current];

        int result = dfs(next, app, loop);
        if (result != -1) {
            if (loop.contains(current)) {
                return -1;
            }
            loop.add(current);
            return result;
        }
        return -1;
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