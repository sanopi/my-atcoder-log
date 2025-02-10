import java.io.PrintWriter;
import java.util.Scanner;

public class Q10 {

    private static void solve() {
        int n = nextInt();
        int[][] p =  new int[2][n+1];
        for (int i = 0; i < n; i++) {
            int c = nextInt()-1;
            p[c][i+1] = nextInt();
        }

        for (int i = 0; i < n; i++) {
            p[0][i+1] += p[0][i];
            p[1][i+1] += p[1][i];
        }
        int q = nextInt();
        while (q --> 0){
            int l = nextInt()-1;
            int r = nextInt()-1;
            out.println((p[0][r+1]-p[0][l]) + " " + (p[1][r+1]-p[1][l]));
        }

        out.flush();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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