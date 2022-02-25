import java.io.PrintWriter;
import java.util.Scanner;

public class Codefestival2016QualaC {

    public static void main(String[] args) {
        String s = next();
        int k = nextInt();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int diffToA = ('z' + 1 - chars[i])%26;
            if (diffToA <= k) {
                chars[i]='a';
                k-=diffToA;
            }
        }
        char last = chars[chars.length - 1];
        chars[chars.length - 1] = (char) ((last-'a'+k)%26 +'a');
        out.println(String.valueOf(chars));
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