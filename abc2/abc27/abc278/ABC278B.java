import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.Scanner;

public class ABC278B {

    public static void main(String[] args) {
        int h = nextInt();
        int m = nextInt();
        LocalTime time = LocalTime.of(h, m);
        for (int i = 0; i < 24 * 60; i++) {
            LocalTime t = time.plusMinutes(i);
            String hh = String.format("%02d", t.getHour());
            String mm = String.format("%02d", t.getMinute());
            int nhi = (hh.charAt(0)-'0')*10 + mm.charAt(0)-'0';
            int nmi = (hh.charAt(1)-'0')*10 + mm.charAt(1)-'0';
            if (0<=nhi && nhi<=23 && 0<=nmi && nmi<=59) {
                System.out.println(t.getHour() + " " + t.getMinute());
                return;
            }
        }
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