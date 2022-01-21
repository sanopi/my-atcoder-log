import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC143D {

    public static void main(String[] args) {
        int n = nextInt();
        int[] l = nextIntArray(n);
        Arrays.sort(l);
//        long ans = solve1(n, l);
        long ans = solve2(n, l);
        out.println(ans);
        out.flush();
    }
    private static long solve2(int n, int[] l) {
        long ans = 0;
        for (int a = 0; a < n - 2; a++) {
            for (int b = a+1; b < n - 1; b++) {
                for (int c = b+1; c < n; c++) {
                    if (l[a]+l[b]>l[c]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private static long solve1(int n, int[] l) {
        long ans = 0;
        for (int a = 0; a < n - 2; a++) {
            for (int b = a+1; b < n - 1; b++) {
                if (l[a]+ l[b]<= l[b+1]) {
                    continue;
                }
                if (l[a]+ l[b]> l[n -1]) {
                    ans += (n -1) - b;
                    continue;
                }
                int ok = b+1;
                int ng = n -1;
                while (Math.abs(ok-ng) > 1) {
                    int p = (ok+ng)/2;
                    if (l[a]+ l[b]> l[p]) {
                        ok = p;
                    } else {
                        ng = p;
                    }
                }
                ans+=(ok-b);
            }
        }
        return ans;
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