import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC301D {

    public static void main(String[] args) {
        String s = next();
        long n = nextLong();

        if (Long.parseLong(s.replaceAll("\\?", "1"), 2) <= n) {
            System.out.println(Long.parseLong(s.replaceAll("\\?", "1"), 2));
            return;
        }

        if (Long.parseLong(s.replaceAll("\\?", "0"), 2) > n) {
            System.out.println(-1);
            return;
        }

        char[] sc = s.toCharArray();

        List<Integer> qIndice = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                qIndice.add(i);
            }
        }
        int qCount = qIndice.size();
        long ng = (1L << qCount) -1;
        long ok = 0;
        while (ng-ok > 1) {
            long mid = (ok+ng)/2;
            char[] copy = Arrays.copyOf(sc, sc.length);
            for (int i = 0; i < qCount; i++) {
                if ((mid & 1L<< qCount-i-1) == 0) {
                    copy[qIndice.get(i)] = '0';
                } else {
                    copy[qIndice.get(i)] = '1';
                }
            }
            if (Long.parseLong(String.valueOf(copy), 2) <= n) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        char[] copy = Arrays.copyOf(sc, sc.length);
        for (int i = 0; i < qCount; i++) {
            if ((ok & 1L<< qCount-i-1) == 0) {
                copy[qIndice.get(i)] = '0';
            } else {
                copy[qIndice.get(i)] = '1';
            }
        }
        out.println(Long.parseLong(String.valueOf(copy), 2));

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