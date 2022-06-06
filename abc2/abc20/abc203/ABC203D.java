import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC203D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int t = k*k - k*k/2;
        List<Num> nums = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = nextInt();
                max =Math.max(max, a);
                nums.add(new Num(a, i, j));
            }
        }

        int ok = max;
        int ng = -1;
        while (ok-ng > 1) {
            // 中央値がX以下の区間が存在する
            // X以下数の個数が、中央値の部分の数より多ければOK
            // X X X X Y Y Y -> OK
            // X X X Y Y Y Y   -> NG
            int x = (ok+ng)/2;
            int[][] count = new int[n][n];
            for (Num num : nums) {
                if (num.a <= x) {
                    count[num.i][num.j]+=1;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    count[i][j] += count[i][j-1];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    count[j][i] += count[j-1][i];
                }
            }

            boolean isOk = false;
            for (int i = 0; i+k-1 < n; i++) {
                for (int j = 0; j+k-1 < n; j++) {
                    int ii = i + k - 1;
                    int jj = j + k - 1;
                    long query = count[ii][jj] - (i>0?count[i-1][jj]:0) - (j>0?count[ii][j-1]:0) + (i>0&&j>0?count[i-1][j-1]:0);
                    if (query >= t) {
                        isOk = true;
                    }
                }
            }
            if (isOk) {
                ok = x;
            } else {
                ng = x;
            }
        }

        out.println(ok);
        out.flush();
    }

    private static class Num {
        int a;
        int i;
        int j;
        public Num(int a, int i, int j) {
            this.a = a;
            this.i = i;
            this.j = j;
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
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