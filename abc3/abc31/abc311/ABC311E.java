import java.io.PrintWriter;
import java.util.Scanner;

public class ABC311E {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int n = nextInt();
        int[][] hole = new int[h+1][w+1];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            hole[a][b] = 1;
        }
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < w; j++) {
                hole[i][j+1] += hole[i][j];
            }
        }
        for (int j = 0; j <= w; j++) {
            for (int i = 0; i < h; i++) {
                hole[i+1][j] += hole[i][j];
            }
        }



        long ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int ok = 0;
                int ng = Math.min(h-i+1, w-j+1);
                while (ng - ok > 1) {
                    int mid = (ok+ng)/2;
                    int count = hole[i+mid][j+mid]
                        - hole[i][j+mid]
                        - hole[i+mid][j]
                        + hole[i][j];
                    if (count == 0) {
                        ok = mid;
                    } else {
                        ng = mid;
                    }
                }
                ans += ok;
            }
        }
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