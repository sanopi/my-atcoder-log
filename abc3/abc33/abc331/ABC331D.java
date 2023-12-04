import java.io.PrintWriter;
import java.util.Scanner;

public class ABC331D {

    private static long[][] counts;
    private static char[][] p;
    private static int n;
    private static int q;
    private static void solve() {
        init();
        while (q --> 0) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            int d = nextInt();
            int upperA = (a/n+1)*n-1;
            int upperB = (b/n+1)*n-1;
            int lowerC = (c/n)*n;
            int lowerD = (d/n)*n;
            int iRepCount = Math.max(0, (lowerC-upperA-1)/n);
            int jRepCount = Math.max(0, (lowerD-upperB-1)/n);
//            System.out.println(upperA + " " + upperB + " " + lowerC + " " + lowerD);
            /*
3 1
WWB
BBW
WBW
0 0 0 6
             */

            long ans = 0;
            if (c<=upperA) {
                if (d <= upperB) {
                    // 左上のみ
                    ans += calc(c%n+1, d%n+1, a%n, b%n);
                } else {
                    // 上一行と右たくさん
                    ans += calc(c%n+1, n, a%n, b%n);
                    ans += (calc(c%n+1,n, a%n,0))*jRepCount;
                    ans += calc(c%n+1,d%n+1, a%n,0);
                }
            } else {
                if (d <= upperB) {
                    // 左一列と下たくさん
                    ans += calc(n,d%n+1, a%n,b%n);
                    ans += (calc(n,d%n+1, 0,b%n))*iRepCount;
                    ans += calc(c%n+1,d%n+1, 0,b%n);
                } else {
                    // 全部
                    ans += calc(n,n, a%n,b%n);
                    ans += calc(c%n+1,n, 0,b%n);
                    ans += calc(n,d%n+1, a%n,0);
                    ans += calc(c%n+1,d%n+1, 0,0);
                    ans += (calc(n,n, a%n,0))*jRepCount;
                    ans += (calc(n,n, 0,b%n))*iRepCount;
                    ans += (calc(c%n+1,n, 0,0))*jRepCount;
                    ans += (calc(n,d%n+1, 0,0))*iRepCount;
                    ans += counts[n][n]*iRepCount*jRepCount;
                }
            }
            out.println(ans);
        }
        out.flush();
    }

    private static void init() {
        n = nextInt();
        q = nextInt();
        p = new char[n][n];
        for (int i = 0; i < n; i++) {
            p[i] = next().toCharArray();
        }
        counts = new long[n +1][n +1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] == 'B') {
                    counts[i+1][j+1]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n+1; j++) {
                counts[i+1][j] += counts[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 1; i <= n; i++) {
                counts[i][j+1] += counts[i][j];
            }
        }
    }

    private static long calc(int a, int b, int c, int d) {
        return counts[c][d]-counts[c][b]-counts[a][d]+counts[a][b];
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