import java.io.PrintWriter;
import java.util.Scanner;

public class Tenka1_2019_BeginnerC {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        char[] chars = s.toCharArray();
        int[] blackSumLeft = new int[n+1];
        int[] whiteSumRight = new int[n+1];
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            blackSumLeft[i+1] = blackSumLeft[i] + (c=='#'?1:0);
        }
        for (int i = n-1; i >= 0; i--) {
            char c = chars[i];
            whiteSumRight[i] = whiteSumRight[i+1] + (c=='.'?1:0);
        }
        int ans = n;
        for (int i = 0; i < n + 1; i++) {
            ans = Math.min(ans, blackSumLeft[i]+ whiteSumRight[i]);
        }

        out.println(ans);
        out.flush();
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