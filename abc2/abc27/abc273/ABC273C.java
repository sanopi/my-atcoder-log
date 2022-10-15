import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ABC273C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            treeMap.merge(a[i], 1, Math::addExact);
        }
        int kindCount = 0;
        for (int i = 0; i < n; i++) {
            if (kindCount == i) {
                Map.Entry<Integer, Integer> entry = treeMap.pollLastEntry();
                out.println(entry != null ? entry.getValue() : 0);
                kindCount++;
            } else {
                out.println(0);
            }
        }

        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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