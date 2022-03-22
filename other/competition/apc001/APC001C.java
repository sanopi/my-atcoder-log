import java.io.PrintWriter;
import java.util.Scanner;

public class APC001C {

    private static final String MALE = "Male";
    private static final String FEMALE = "Female";
    private static final String VACANT = "Vacant";

    public static void main(String[] args) {
        int n = nextInt();
        System.out.println(0);
        String first = next();
        if (VACANT.equals(first)) return;

        int min = 0;
        int max = n;
        for (int i = 0; i < 20; i++) {
            int point = (min + max) / 2;
            System.out.println(point);
            String res = next();
            if (VACANT.equals(res)) return;

            if (point%2 == 0) {
                if (first.equals(res)) { // 正しい方
                    min = point;
                } else {
                    max = point;
                }
            } else {
                if (!first.equals(res)) { // 正しい方
                    min = point;
                } else {
                    max = point;
                }
            }
        }
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