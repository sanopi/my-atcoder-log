import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC213C {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int n = nextInt();

        int[] aa = new int[n];
        int[] bb = new int[n];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int b = nextInt();
            aa[i] = a;
            bb[i] = b;
        }
        int[] aaa = Arrays.copyOf(aa, aa.length);
        int[] bbb = Arrays.copyOf(bb, bb.length);
        Map<Integer, Integer> aOrder = new HashMap<>();
        Map<Integer, Integer> bOrder = new HashMap<>();
        Arrays.sort(aaa);
        Arrays.sort(bbb);
        int ai = 1;
        int bi = 1;
        aOrder.put(aaa[0], ai);
        bOrder.put(bbb[0], bi);
        for (int i = 1; i < n; i++) {
            if (aaa[i] != aaa[i-1]) {
                ai += 1;
            }
            if (bbb[i] != bbb[i-1]) {
                bi += 1;
            }
            aOrder.put(aaa[i], ai);
            bOrder.put(bbb[i], bi);

        }

        for (int i = 0; i < n; i++) {
            out.println(aOrder.get(aa[i]) + " " + bOrder.get(bb[i]));
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
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }

}