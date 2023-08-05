import java.io.PrintWriter;
import java.util.Scanner;

public class ABC313D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] ans = new int[n];
        int[] res = new int[n];
        for (int i = 0; i < k+1; i++) {
            out.print("? ");
            for (int j = 0; j < k + 1; j++) {
                if (i==j) continue;
                out.print(j+1+" ");
            }
            out.println();
            out.flush();
            int rseI = nextInt();
            res[i] = rseI;
            if (i>=1) {
                if (res[i] == res[i-1]) {
                    ans[i] = ans[i-1];
                } else {
                    ans[i] = 1-ans[i-1];
                }
            }
        }
        for (int i = k+1; i < n; i++) {
            out.print("? ");
            for (int j = 0; j < k - 1; j++) {
                out.print(j+1+" ");
            }
            out.print(i+1);
            out.println();
            out.flush();
            int resI = nextInt();
            res[i] = resI;
            if (i == k+1) {
                if (res[i] == res[k-1]) {
                    ans[i] = ans[i-1];
                } else {
                    ans[i] = 1-ans[i-1];
                }
            } else {
                if (res[i] == res[i-1]) {
                    ans[i] = ans[i-1];
                } else {
                    ans[i] = 1-ans[i-1];
                }
            }
        }

        int oneCount = 0;
        for (int j = 0; j < k; j++) {
            if (ans[j] == 1) oneCount++;
        }
        boolean yes = oneCount % 2 == res[k];
        out.print("! ");
        for (int an : ans) {
            if (yes) {
                out.print(an+ " ");
            } else {
                out.print(1-an+ " ");
            }
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