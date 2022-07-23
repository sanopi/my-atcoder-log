import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC261F {

    private static long count = 0;

    public static void main(String[] args) {
        int n = nextInt();
        int[] c = nextIntArray(n);
        int[] x = nextIntArray(n);
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(c[i], x[i]);
        }
        sort(pairs);
        out.println(count);
        out.flush();
    }

    private static Pair[] sort(Pair[] pairs) {
        int len = pairs.length;
        if (len <= 1) {
            return pairs;
        }
        int half = len / 2;
        Pair[] a = sort(Arrays.copyOfRange(pairs, 0, half));
        Pair[] b = sort(Arrays.copyOfRange(pairs, half, len));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            Pair pa = a[i];
            map.put(pa.c, map.getOrDefault(pa.c, 0)+1);
        }
        int ai = 0;
        int bi = 0;
        Pair[] result = new Pair[len];
        while (ai < a.length && bi < b.length) {
            Pair pa = a[ai];
            Pair pb = b[bi];
            if (pa.x <= pb.x) {
                result[ai+bi] = pa;
                map.put(pa.c, map.get(pa.c)-1);
                ai++;
            } else {
                result[ai+bi] = pb;
                count += (a.length-ai) - map.getOrDefault(pb.c, 0);
                bi++;
            }
        }
        while (ai < a.length) {
            result[ai+bi] = a[ai];
            ai++;
        }
        while (bi < b.length) {
            result[ai+bi] = b[bi];
            bi++;
        }

        return result;
    }

    private static class Pair {
    int c;
    int x;
     public Pair(int c, int x) {
         this.c = c;
         this.x = x;
     }
        @Override
        public String toString() {
            return "Pair{" +
                "c=" + c +
                ", x=" + x +
                '}';
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