import java.io.PrintWriter;
import java.util.Scanner;

public class ABC192D {

    public static void main(String[] args) {
        String x = next();
        int n = x.length();

        long m = nextLong();
        if (n == 1) {
            System.out.println(Integer.parseInt(x)<=m?1:0);
            return;
        }
        char[] chars = x.toCharArray();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, chars[i]-'0');
        }
        long ng = m+1;
        long ok = max;
        while (ng-ok > 1){
            long mid = (ok+ng)/2;
            try {
                long result = parse(chars, mid);
                if (result <= m) {
                    ok = mid;
                } else {
                    ng = mid;
                }
            } catch (ArithmeticException e) {
                ng = mid;
            }
        }
        out.println(ok-max);
        out.flush();
    }

    private static long parse(char[] chars, long base) {
        int n = chars.length;
        long[] baseArr = new long[n];
        baseArr[0] = 1;
        int i = 1;
        while (i<n) {
            baseArr[i] = Math.multiplyExact(baseArr[i-1], base);
            i++;
        }

        long res = 0;
        for (int j = 0; j < n; j++) {
            res = Math.addExact(res, Math.multiplyExact(baseArr[j], (chars[n-1-j]-'0')));
        }
        return res;
    }


    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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