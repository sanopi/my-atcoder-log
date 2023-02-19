import java.io.PrintWriter;
import java.util.Scanner;

public class ABC289C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] sets = new int[m];
        for (int i = 0; i < m; i++) {
            int c = nextInt();
            for (int j = 0; j < c; j++) {
                sets[i] |= 1<<(nextInt()-1);
            }
        }
        int ans = 0;
        int idea = (1<<n)-1;
        for (int i = 1; i < 1 << m; i++) {
            int merged = 0;
            for (int j = 0; j < m; j++) {
                if ((i&(1<<j)) != 0) {
                    merged |= sets[j];
                }
            }
            if (merged == idea) {
                ans++;
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