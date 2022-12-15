import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC281F {

    public static void main(String[] args) {
        int n = nextInt();
        List<Long> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(nextLong());
        }
        out.println(solve(a, 30));

        out.flush();
    }

    private static long solve(List<Long> list, int exp) {
        if (exp < 0) {
            return 0;
        }
        List<Long> zero = new ArrayList<>();
        List<Long> one = new ArrayList<>();
        for (Long l : list) {
            if ((l & (1L<<exp)) == 0) {
                one.add(l);
            } else {
                zero.add(l);
            }
        }
        long add =  (one.size() == 0 || zero.size() == 0) ? 0 : 1L<<exp;
        return add + Math.min(zero.size() > 0 ? solve(zero, exp-1) : Long.MAX_VALUE/2, one.size() > 0 ? solve(one, exp-1) : Long.MAX_VALUE/2);
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