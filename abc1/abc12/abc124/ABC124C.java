import java.io.PrintWriter;
import java.util.Scanner;

public class ABC124C {

    public static void main(String[] args) {
        String s = next();
        char[] chars = s.toCharArray();
        int shouldBe = 0;
        int count1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' != shouldBe) {
                count1++;
            }
            shouldBe = (shouldBe+1)%2;
        }
        shouldBe = 1;
        int count2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' != shouldBe) {
                count2++;
            }
            shouldBe = (shouldBe+1)%2;
        }
        out.println(Math.min(count1, count2));
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