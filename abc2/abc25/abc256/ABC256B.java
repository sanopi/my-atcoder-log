import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC256B {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);

        int p = 0;
        List<Integer> koma = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            koma.add(0);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < koma.size(); j++) {
                Integer kj = koma.get(j);
                if (kj + a[i] >= 4) {
                    p++;
                } else {
                    tmp.add(kj + a[i]);
                }
            }
            koma = tmp;
        }
        out.println(p);
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