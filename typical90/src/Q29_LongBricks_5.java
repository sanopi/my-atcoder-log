import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q29_LongBricks_5 {

    public static void main(String[] args) {
        solve1();
    }

    /**
     * 座標圧縮による高速化
     */
    public static void solve1() {
        int w = nextInt();
        int n = nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = nextInt()-1;
            int r = nextInt()-1;
            list.add(l);
            list.add(r);
        }
        List<Integer> collect = list.stream().distinct().sorted().collect(Collectors.toList());
        int[] h = new int[collect.size()];

        for (int i = 0; i < list.size(); i+=2) {
            int l = Collections.binarySearch(collect, list.get(i));
            int r = Collections.binarySearch(collect, list.get(i + 1));
            int max = 0;
            for (int j = l; j <= r; j++) {
                if (h[j] > max) {
                    max = h[j];
                }
            }
            for (int j = l; j <= r; j++) {
                h[j] = max+1;
            }
            out.println(max+1);
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