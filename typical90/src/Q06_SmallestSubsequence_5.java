import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Q06_SmallestSubsequence_5 {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        char[] s = next().toCharArray();

        int[][] c = new int[n+1][26];
        Arrays.fill(c[n], n);
        for (int i = n-1; i >= 0; i--) {
            int si = s[i] - 'a';
            for (int j = 0; j < 26; j++) {
                if (j == si) {
                    c[i][j] = i;
                } else {
                    c[i][j] = c[i+1][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder(k);
        for (int i = 0; i < n && k > 0;) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j] > n-k) {
                    continue;
                }
                sb.append((char) (j + 'a'));
                k -= 1;
                i = c[i][j] + 1;
                break;
            }
        }
        out.println(sb.toString());
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
}