import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC278D {

    public static void main(String[] args) {
        int n = nextInt();
        long[] a = nextLongArray(n);
        int q = nextInt();
        long base = 0;
        Set<Integer> fixed = new HashSet<>();
        for (int i = 0; i < n; i++) fixed.add(i);
        while (q-- > 0) {
            int t = nextInt();
            if (t == 1) {
                int x = nextInt();
                base = x;
                fixed = new HashSet<>();
            } else if (t == 2) {
                 int i = nextInt()-1;
                 int x = nextInt();
                if (fixed.contains(i)) {
                    a[i] += x;
                } else {
                    a[i] = base+x;
                    fixed.add(i);
                }
            } else {
                int i = nextInt()-1;
                if (fixed.contains(i)) {
                    out.println(a[i]);
                } else {
                    out.println(base);
                }
            }
        }
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