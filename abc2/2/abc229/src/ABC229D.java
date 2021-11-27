import java.io.PrintWriter;
import java.util.Scanner;

public class ABC229D {

    public static void main(String[] args) {
        char[] s = next().toCharArray();
        int k = nextInt();

        if (k == 0) {
            int ans = 0;
            int tmp = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i] == 'X') {
                    tmp++;
                } else {
                    tmp = 0;
                }
                ans = Math.max(ans, tmp);
            }
            System.out.println(ans);
            return;
        }

        int right = 0;
        int left = 0;
        int ans = 0;
        while (right<s.length) {
            if (s[right] == 'X') {
                right++;
            } else if (k > 0) {
                right++;
                k--;
            } else {
                if (s[left] == '.') {
                    k++;
                }
                left++;
            }
            ans = Math.max(ans, right - left);
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