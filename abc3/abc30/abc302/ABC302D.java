import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC302D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        long d = nextLong();
        long[] a = nextLongArray(n);
        long[] b = nextLongArray(m);
        TreeSet<Long> bSet = new TreeSet<>();
        for (long l : b) {
            bSet.add(l);
        }

        long ans = -1;
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            long max = ai+d;
            Long found = bSet.floor(max);
            if (found == null) continue;
            if (Math.abs(ai-found) <= d) {
                ans = Math.max(ans, ai+found);
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