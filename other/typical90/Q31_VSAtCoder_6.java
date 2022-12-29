import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q31_VSAtCoder_6 {

    private static int[][] grundy;
    public static void main(String[] args) {
        int n = nextInt();
        int[] w = nextIntArray(n);
        int[] b = nextIntArray(n);
        calcGrundyNum(50, 50);
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= grundy[w[i]][b[i]];
        }
        out.println(xor == 0 ? "Second" : "First");
        out.flush();
    }

    private static void calcGrundyNum(int w, int b) {
        // 白を1減らして青をiだけ増やす
        // 青を1-b/2の間だけ減らす

        int maxBlue = (1 + w) * w / 2 + b;
        grundy = new int[w+1][maxBlue+1];
        for (int i = 0; i <= w; i++) {
            for (int j = 0; j <= maxBlue-i; j++) {
                Set<Integer> set = new HashSet<>();
                if (i==0&&j==1) continue;
                if (i>0) {
                    set.add(grundy[i-1][j+i]);
                }
                for (int k = 1; k <= j / 2; k++) {
                    set.add(grundy[i][j-k]);
                }
                int num = 0;
                while (set.contains(num)) {
                    num++;
                }
                grundy[i][j] = num;
            }
        }
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