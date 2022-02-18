import java.io.PrintWriter;
import java.util.Scanner;

public class ABC064D {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();

        int leftCount = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else {
                leftCount--;
            }
            leftMin = Math.min(leftMin, leftCount);
        }
        s = "(".repeat(-Math.min(leftMin, 0)) + s;

        int rightCount = 0;
        int rightMin = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                rightCount++;
            } else {
                rightCount--;
            }
            rightMin = Math.min(rightMin, rightCount);
        }
        s = s + ")".repeat(-Math.min(rightCount, 0)) ;

        out.println(s);
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