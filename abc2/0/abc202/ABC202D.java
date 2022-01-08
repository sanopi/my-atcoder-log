import java.io.PrintWriter;
import java.util.Scanner;

public class ABC202D {

    private static final long[][] memo = new long[31][31];
    static {
        for (int i = 1; i < 31; i++) {
            memo[0][i] = 1;
            memo[1][i] = i+1;
            memo[i][0] = 1;
            memo[i][1] = i+1;
        }
    }

    public static void main(String[] args) {
        int a = nextInt();
        int b = nextInt();
        long k = nextLong();

        StringBuilder sb = new StringBuilder();

        while (a > 0 && b > 0) {
            if (count(a-1, b) >= k) {
                a--;
                sb.append("a");
            } else {
                k-=count(a-1, b);
                sb.append("b");
                b--;
            }
        }
        sb.append("a".repeat(a));
        sb.append("b".repeat(b));

        out.println(sb);
        out.flush();
    }

    private static long count(int a, int b) {
        if (memo[a][b] != 0) { return memo[a][b]; }
        long countA = count(a-1, b);
        long countB = count(a, b-1);
        memo[a][b] = countA+countB;
        return memo[a][b];
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