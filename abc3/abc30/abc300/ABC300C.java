import java.io.PrintWriter;
import java.util.Scanner;

public class ABC300C {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int n = Math.min(h, w);

        char[][] c = new char[h][w];
        for (int i = 0; i < h; i++) {
            c[i] = next().toCharArray();
        }
        int[] ans = new int[n+1];
        boolean[][] done = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int x = j;
                int y = i;
                if (c[y][x] == '.') continue;
                if (done[y][x]) continue;
                int count = 1;
                while (true) {
                    x += 1;
                    y += 1;
                    if (x >= w || y >= h) break;
                    if (c[y][x] == '.') break;
                    count++;
                    done[y][x] = true;
                }
                ans[count/2]++;
            }
        }


        for (int i = 1; i < n + 1; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
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