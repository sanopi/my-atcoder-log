import java.io.PrintWriter;
import java.util.Scanner;

public class ARC155A {

    public static void main(String[] args) {
        int t = nextInt();
        while (t --> 0) {
            int n = nextInt();
            long k = nextLong();
            String s = next();
            boolean result;
            if (n >= k) {
                result = solveSmall(n, (int)k, s);
            } else {
                int k1 = (int) ((k + n) % (2 * n));
                int rest = (int) ((k + n) / (2 * n)) % 2;
                result = solveLarge(n, k1, s, rest == 1);
            }
            out.println(result ? "Yes" : "No");
        }
        out.flush();
    }

    private static boolean solveSmall(int n, int k, String s) {
        String revS = new StringBuilder(s).reverse().toString();
        String revSSub = revS.substring(0, k);
        String revSSub1 = revS.substring(n-k, n);

        return revSSub.equals(revSSub1);
    }
    private static boolean solveLarge(int n, int k, String s, boolean front) {
        s = new StringBuilder(s).reverse() + s;
        String sub;
        if (front) {
            sub = s.substring(0, k);
            return sub.equals(new StringBuilder(sub).reverse().toString())
                && (s+sub).equals(new StringBuilder(s+sub).reverse().toString());
        } else {
            sub = s.substring(2*n-k, 2*n);
            return sub.equals(new StringBuilder(sub).reverse().toString())
                && (sub+s).equals(new StringBuilder(sub+s).reverse().toString());
        }

    }

//    private static boolean solveLarge(int n, int k, String s) {
//        String revS = new StringBuilder(s).reverse().toString();
//        String revSSsub = (revS+s).substring(0, k);
//        return revSSsub.equals(new StringBuilder(revSSsub).reverse().toString());
//    }

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