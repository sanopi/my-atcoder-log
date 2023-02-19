import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC290C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n + 1; i++) {
            treeSet.add(i);
        }
        for (int i = 0; i < n; i++) {
            int ai = nextInt();
            treeSet.remove(ai);
        }
        Integer ans = treeSet.ceiling(0);
        out.println(Math.min(k, ans));
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