import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC279C {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] ss = new char[h][w];
        char[][] tt = new char[h][w];
        for (int i = 0; i < h; i++) {
            ss[i] = next().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            tt[i] = next().toCharArray();
        }
        char[][] invSs = new char[w][h];
        char[][] invTt = new char[w][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                invSs[j][i] = ss[i][j];
                invTt[j][i] = tt[i][j];
            }
        }
        String[] s = new String[w];
        String[] t = new String[w];
        for (int i = 0; i < w; i++) {
            s[i] = String.valueOf(invSs[i]);
            t[i] = String.valueOf(invTt[i]);
        }
        Arrays.sort(s);
        Arrays.sort(t);
        out.println(Arrays.equals(s, t) ? "Yes" : "No");

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