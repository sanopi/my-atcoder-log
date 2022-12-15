import java.io.PrintWriter;
import java.util.Scanner;

public class ABC281B {

    public static void main(String[] args) {
        String s = next();
        if (s.length() != 8) {
            System.out.println("No");
            return;
        }
        char first = s.charAt(0);
        if ('A' > first || 'Z' <first) {
            System.out.println("No");
            return;
        }
        char last = s.charAt(s.length()-1);
        if ('A' > last || 'Z' <last) {
            System.out.println("No");
            return;
        }
        try {
            int i = Integer.parseInt(s.substring(1).substring(0, s.length() - 2));
            if (100000 <= i && i <= 999999) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (NumberFormatException e) {
            System.out.println("No");
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