import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC315C {

    private static void solve() {
        int n = nextInt();
        Pair[] pairs = new Pair[n];
        List<Integer>[] ff = new List[n];
        for (int i = 0; i < n; i++) {
            ff[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int f = nextInt()-1;
            int s = nextInt();
            pairs[i] = new Pair(f, s);
            ff[f].add(s);
        }
        int ans = 0;
        List<Integer> distinct = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ff[i].sort(Comparator.reverseOrder());
            if (ff[i].size() > 0) {
                distinct.add(ff[i].get(0));
            }
            if (ff[i].size() > 1) {
                ans = Math.max(ans, ff[i].get(0) + ff[i].get(1)/2);
            }
        }
        distinct.sort(Comparator.reverseOrder());
        if (distinct.size()>1) {
            ans = Math.max(ans, distinct.get(0)+distinct.get(1));
        }
        out.println(ans);
        out.flush();
    }

    private static class Pair {
        int f;
        int s;
        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "", 16 * 1024 * 1024).start();
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