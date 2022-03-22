import java.io.PrintWriter;
import java.util.Scanner;

public class ABC244D {

    public static void main(String[] args) {
        String s1 = next();
        String s2 = next();
        String s3 = next();
        String t1 = next();
        String t2 = next();
        String t3 = next();
        boolean same1 = s1.equals(t1);
        boolean same2 = s2.equals(t2);
        boolean same3 = s3.equals(t3);
        int sameCount = 0;
        sameCount += same1?1:0;
        sameCount += same2?1:0;
        sameCount += same3?1:0;
        if (sameCount==1) {
            out.println("No");
        } else {
            out.println("Yes");
        }
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