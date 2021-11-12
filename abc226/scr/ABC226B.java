import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC226B {

    public static void main(String[] args) {
        int n = nextInt();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int l = nextInt();
            List<Integer> list = new ArrayList<Integer>();
            list.add(l);
            for (int j = 0; j < l; j++) {
                list.add(nextInt());
            }
            set.add(list);
        }
        System.out.println(set.size());
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