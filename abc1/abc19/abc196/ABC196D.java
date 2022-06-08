import java.io.PrintWriter;
import java.util.Scanner;

public class ABC196D {

    private static final int[] X = {1, 0};
    private static final int[] Y = {0, 1};
    private static int h;
    private static int w;
    private static boolean[][] done;
    private static int ans = 0;

    public static void main(String[] args) {
        h = nextInt();
        w = nextInt();
        int a = nextInt();
        int b = nextInt();
        int n = h * w;
        done = new boolean[h][w];
        solve(0, 0, a, b);
        out.println(ans);
        out.flush();
    }

    private static void solve(int cx, int cy, int a, int b) {
        if (cx==h) {
            cx=0;
            cy++;
        }
        if (a==0 && b==0) {
            ans++;
            return;
        }
        if (done[cx][cy]) {
            solve(cx+1, cy, a, b);
            return;
        }
        if (a>0) {
            if (cx+1<h && !done[cx+1][cy]) {
                done[cx][cy] = true;
                done[cx+1][cy] = true;
                solve(cx+2, cy, a-1, b);
                done[cx][cy] = false;
                done[cx+1][cy] = false;
            }
            if (cy+1<w && !done[cx][cy+1]) {
                done[cx][cy] = true;
                done[cx][cy+1] = true;
                solve(cx+1, cy, a-1, b);
                done[cx][cy] = false;
                done[cx][cy+1] = false;
            }
        }
        if (b>0) {
            done[cx][cy] = true;
            solve(cx+1, cy, a, b-1);
            done[cx][cy] = false;
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