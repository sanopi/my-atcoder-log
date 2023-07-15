import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC310B {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Set<Integer>[] f = new Set[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = nextInt();
            int c = nextInt();
            f[i] = new HashSet<>();
            for (int j = 0; j < c; j++) {
                f[i].add(nextInt());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!(p[i] >= p[j])) continue;
                if (!f[j].containsAll(f[i])) continue;
                if (!((p[i] > p[j]) || !f[i].containsAll(f[j]))) continue;
                System.out.println("Yes");
                return;
            }
        }
        out.println("No");
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