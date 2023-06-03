import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC302B {

    private static char[] SNUKE = "snuke".toCharArray();
    private static int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] Y = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        char[][] a = new char[h][w];
        for (int i = 0; i < h; i++) {
            a[i] = next().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < 8; k++) {
                    char[] chars = new char[5];
                    for (int l = 0; l < 5; l++) {
                        int ni = i+Y[k]*l;
                        int nj = j+X[k]*l;
                        if (0<=ni && ni<h && 0<=nj && nj<w) {
                            chars[l] = a[ni][nj];
                        } else {
                            break;
                        }
                    }
                    if (Arrays.equals(chars, SNUKE)) {
                        for (int l = 0; l < 5; l++) {
                            int ni = i + Y[k] * l +1;
                            int nj = j + X[k] * l +1;
                            System.out.println(ni + " " + nj);
                        }
                        return;
                    }
                }
            }
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