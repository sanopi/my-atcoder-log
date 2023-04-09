import java.io.PrintWriter;
import java.util.Scanner;

public class ABC297C {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] chars = new char[h][w];
        for (int i = 0; i < h; i++) {
            chars[i] = next().toCharArray();
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w-1; j++) {
                if (chars[i][j] == 'T' && chars[i][j+1] == 'T') {
                    chars[i][j] = 'P';
                    chars[i][j+1] = 'C';
                }
            }
        }
        for (int i = 0; i < h; i++) {
            out.println(String.valueOf(chars[i]));
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