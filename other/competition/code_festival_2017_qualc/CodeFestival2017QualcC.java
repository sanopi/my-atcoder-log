import java.io.PrintWriter;
import java.util.Scanner;

public class CodeFestival2017QualcC {

    public static void main(String[] args) {
        String s = next();
        int left = 0;
        int right = s.length()-1;
        int count = 0;
        boolean ok = true;
        while (left<=right) {
            char cl = s.charAt(left);
            char cr = s.charAt(right);
            if (cl=='x' && cr!='x') {
                left++;
                count++;
                continue;
            }
            if (cl!='x' && cr=='x') {
                right--;
                count++;
                continue;
            }
            if (cl == cr) {
                left++;
                right--;
                continue;
            }
            ok=false;
            break;
        }
        out.println(ok?count:-1);
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