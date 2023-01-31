import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ARC155B {

    public static void main(String[] args) {
        int q = nextInt();
        int A = nextInt();
        int B = nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        set.add(A+B);
        set.add(A-B);
        for (int i = 0; i < q; i++) {
            int t = nextInt();
            int a = nextInt();
            int b = nextInt();
            if (t == 1) {
                set.add(a+b);
                set.add(a-b);
            } else {
                Integer ceiling = set.ceiling(a);
                if (ceiling != null && ceiling <= b) {
                    out.println(0);
                    continue;
                }
                Integer floor = set.floor(a);
                Integer ceil = set.ceiling(b);
                int ans = Integer.MAX_VALUE;
                if (floor != null) {
                    ans = Math.min(ans, a-floor);
                }
                if (ceil != null) {
                    ans = Math.min(ans, ceil-b);
                }
                out.println(ans);
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