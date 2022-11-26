import java.io.PrintWriter;
import java.util.Scanner;

public class ABC278E {

    public static void main(String[] args) {
        int H = nextInt();
        int W = nextInt();
        int N = nextInt();
        int h = nextInt();
        int w = nextInt();
        int[][] a = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                a[i][j] = nextInt();
            }
        }

        int[][][] counts = new int[H+1][W+1][N+1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                counts[i+1][j+1][a[i][j]]++;
            }
        }

        for (int i = 1; i < H+1; i++) {
            for (int j = 0; j < W+1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    counts[i][j][k] += counts[i-1][j][k];
                }
            }
        }
        for (int i = 0; i < H+1; i++) {
            for (int j = 1; j < W+1; j++) {
                for (int k = 0; k < N + 1; k++) {
                    counts[i][j][k] += counts[i][j-1][k];
                }
            }
        }

        for (int k = 0; k <= H - h; k++) {
            for (int l = 0; l <= W - w; l++) {
                int[] count = new int[N+1];
                for (int i = 0; i < N + 1; i++) {
                    // 全
                    count[i] = counts[H][W][i];
                    // -黒塗りまで
                    count[i] -= counts[k+h][l+w][i];
                    // +上
                    count[i] += counts[k][l+w][i];
                    // +左
                    count[i] += counts[k+h][l][i];
                    // -左上
                    count[i] -= counts[k][l][i];
                }
                int ans = 0;
                for (int i = 1; i < N + 1; i++) {
                    if (count[i]>0) {
                        ans++;
                    }
                }
                out.print(ans + " " );
            }
            out.println();
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