import java.io.PrintWriter;
import java.util.Scanner;

public class ABC264D {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        int[] ints = new int[26];
        ints['a'-'a'] = 0;
        ints['t'-'a'] = 1;
        ints['c'-'a'] = 2;
        ints['o'-'a'] = 3;
        ints['d'-'a'] = 4;
        ints['e'-'a'] = 5;
        ints['r'-'a'] = 6;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = ints[s.charAt(i)-'a'];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count ++;
                }
            }
        }
        out.println(count);
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