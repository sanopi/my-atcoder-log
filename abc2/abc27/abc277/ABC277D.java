import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC277D {

    private static int n;
    private static int m;
    private static int[] a;
    private static long[] memo;
    public static void main(String[] args) {
        n = nextInt();
        m = nextInt();
        a = nextIntArray(n);
        Arrays.sort(a);
        memo = new long[n];
        Arrays.fill(memo, -1);
        long sum = 0;
        for (int i : a) sum += i;

        long ans = sum;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, sum - rec(i, new HashSet<>()));
        }
        out.println(ans);
        out.flush();
    }

    private static long rec(int current, Set<Integer> done) {
        if (memo[current] >= 0) return memo[current];
        if (done.contains(current)) return 0;
        done.add(current);
        long res = a[current];
        if (a[(current+1)%n] == a[current] || a[(current+1)%n] == (a[current]+1)%m) {
            res += rec((current+1)%n, done);
        }
        return memo[current] = res;
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