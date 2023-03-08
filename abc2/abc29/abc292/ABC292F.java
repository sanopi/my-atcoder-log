import java.io.PrintWriter;
import java.util.Scanner;

public class ABC292F {

    public static void main(String[] args) {
        double a = nextInt();
        double b = nextInt();
        double min = Math.min(a, b);
        double max = Math.max(a, b);



        double ok = Math.PI/12;
        double ng = 0;
        int count = 0;

        while (Math.abs(ok-ng) >= 1e-9) {
            count++;
            double mid = (ok+ng)/2;
            double result = calc(min, mid);
            if (result <= max) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        out.println(calcAns(min, ok));
        out.flush();
    }

    private static double calc(double min, double angle) {
        double sanju = Math.PI/6;
        return min*Math.cos(angle)/Math.cos(sanju-angle);
    }

    private static double calcAns(double min, double angle) {
        double sanju = Math.PI/6;
        return min/Math.cos(sanju-angle);
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