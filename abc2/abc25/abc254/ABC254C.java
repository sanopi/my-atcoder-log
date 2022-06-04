import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC254C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);

        for (int i = 0; i < k; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < n; j+=k) {
                list.add(a[j]);
            }
            list.sort(Comparator.naturalOrder());
            for (int j = 0; j < list.size(); j++) {
                a[i+j*k] = list.get(j);
            }
        }
        int[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        out.println(Arrays.equals(a, b) ? "Yes" : "No");
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