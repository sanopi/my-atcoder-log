import java.io.PrintWriter;
import java.util.Scanner;

public class ABC295B {

    public static void main(String[] args) {
        int r = nextInt();
        int c = nextInt();
        char[][] ban = new char[r][c];
        for (int i = 0; i < r; i++) {
            ban[i] = next().toCharArray();
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (ban[i][j] == '.') {
                    continue;
                }
                if (ban[i][j] == '#') {
                    continue;
                }
                int distMax = ban[i][j]-'0';
                for (int rr = -distMax; rr <= distMax; rr++) {
                    if (i+rr < 0 || r <= i+rr) continue;
                    for (int cc = -distMax; cc <= distMax; cc++) {
                        if (j+cc < 0 || c <= j+cc) continue;
                        if (distMax < Math.abs(rr) + Math.abs(cc)) continue;
                        if (ban[i+rr][j+cc] == '#') {
                            ban[i+rr][j+cc] = '.';
                        }
                    }
                }
                ban[i][j] = '.';
            }
        }
        for (char[] chars : ban) {
            out.println(String.valueOf(chars));
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