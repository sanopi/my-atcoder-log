import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC276C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] p = nextIntArray(n);
        int point = n;
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            list.add(p[i]);
            if (p[i] > min) {
                point = i;
                break;
            } else {
                min = p[i];
            }
        }
        list.sort(Comparator.naturalOrder());
        int t = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= p[point]) {
                t = list.get(i-1);
                break;
            }
        }
        list.remove((Integer) t);
        p[point] = t;
        list.sort(Comparator.reverseOrder());
        for (int i = point+1; i < n; i++) {
            p[i] = list.get(i-point-1);
        }

        for (int i : p) {
            out.print(i + " ");
        }
        out.println();
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