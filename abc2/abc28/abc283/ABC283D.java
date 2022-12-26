import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC283D {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        int[] balls = new int[26];
        Arrays.fill(balls, -1);
        int[] depAddIndex = new int[n];
        Arrays.fill(depAddIndex, -1);
        int depth = 0;
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            if (si == '(') {
                depth++;
                depAddIndex[depth] = i;
                continue;
            } else if (si == ')') {
                depth--;
                int target = depAddIndex[depth] + 1;
                for (int j = 0; j < 26; j++) {
                    if (target <= balls[j]) {
                        balls[j] = -1;
                    }
                }
            } else {
                if (balls[si-'a'] != -1) {
                    System.out.println("No");
                    return;
                }
                balls[si-'a'] = i;
            }
        }
        out.println("Yes");
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