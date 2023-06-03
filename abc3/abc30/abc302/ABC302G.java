import java.io.PrintWriter;
import java.util.Scanner;

public class ABC302G {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        int[] countsSum = new int[5];
        for (int i = 0; i < n; i++) {
            countsSum[a[i]]++;
        }
        for (int i = 1; i < 5; i++) {
            countsSum[i] = countsSum[i-1]+countsSum[i];
        }

        // i の枠に j が存在する個数
        int[][] diffCount = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = countsSum[i]; j < countsSum[i+1]; j++) {
                diffCount[i][a[j]-1]++;
            }
        }

        // 1回で交換できる
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                int ij = diffCount[i][j];
                int ji = diffCount[j][i];
                int min = Math.min(ij, ji);
                diffCount[i][j] -= min;
                diffCount[i][i] += min;
                diffCount[j][i] -= min;
                diffCount[j][j] += min;
                ans += min;
            }
        }

        // 2回以上交換に掛かる
        // iの枠から
        for (int i = 0; i < 4; i++) {
            // jを出す
            for (int j = 0; j < 4; j++) {
                if (i==j) continue;
                // kに対して
                for (int k = i+1; k < 4; k++) {
                    int ij = diffCount[i][j];
                    int ki = diffCount[k][i];
                    int min = Math.min(ij, ki);
                    diffCount[i][j] -= min;
                    diffCount[i][i] += min;
                    diffCount[k][i] -= min;
                    diffCount[k][j] += min;
                    ans += min;
                }
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