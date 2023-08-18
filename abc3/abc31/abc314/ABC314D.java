import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC314D {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        char[] ans = s.toCharArray();
        int q = nextInt();
        Set<Integer> indice = new HashSet<>();
        LS ls = LS.NONE;
        while (q-->0) {
            int t = nextInt();
            int x = nextInt()-1;
            char c = next().toCharArray()[0];
            if (t == 1) {
                ans[x] = c;
                indice.add(x);
            } else if (t == 2) {
                ls = LS.SMALL;
                indice = new HashSet<>();
            } else {
                ls = LS.LARGE;
                indice = new HashSet<>();
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ci = ans[i];
            if (indice.contains(i)) {
                result.append(ci);
            } else if (ls == LS.SMALL) {
                result.append(String.valueOf(ci).toLowerCase());
            } else if (ls == LS.LARGE) {
                result.append(String.valueOf(ci).toUpperCase());
            } else {
                result.append(ci);
            }
        }
        out.println(result);
        out.flush();
    }

    enum LS {
        LARGE, SMALL, NONE

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