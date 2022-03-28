import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC245C {

    private static int n;
    private static int k;
    private static int[][] input;

    public static void main(String[] args) {
        n = nextInt();
        k = nextInt();
        input = new int[2][n];
        input[0] = nextIntArray(n);
        input[1] = nextIntArray(n);

        Set<Integer> candidate = new HashSet<>();
        candidate.add(input[0][0]);
        candidate.add(input[1][0]);

        for (int i = 1; i < n; i++) {
            Set<Integer> newCandidate = new HashSet<>();
            for (Integer can : candidate) {
                for (int j = 0; j < 2; j++) {
                    if (Math.abs(can - input[j][i]) <= k) {
                        newCandidate.add(input[j][i]);
                    }
                }
            }
            candidate = newCandidate;
        }
        out.println(candidate.isEmpty() ? "No" : "Yes");
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