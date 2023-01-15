import java.io.PrintWriter;
import java.util.Scanner;

public class ABC285C {

    public static void main(String[] args) {
//        System.out.println(Long.parseLong("A", 26));
        String s = next();
        long[] base = new long[s.length()+1];
        base[1] = 26;
        for (int i = 2; i < s.length()+1; i++) {
            base[i] = base[i-1] * 26;
        }
        for (int i = 1; i < s.length() + 1; i++) {
            base[i] += base[i-1];
        }

        long ans = base[s.length()-1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            if ('A' <= si && si <= 'J') {
                sb.append(si-'A');
            } else {
                sb.append((char)(si-10));
            }
        }
        String x = sb.toString();
        ans += Long.parseLong(x, 26)+1;
        out.println(ans);
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