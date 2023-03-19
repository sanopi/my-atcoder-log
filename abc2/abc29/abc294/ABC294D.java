import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;

public class ABC294D {

    public static void main(String[] args) {
        int n = nextInt();
        TreeSet<Integer> taiki = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            taiki.add(i+1);
        }
        TreeSet<Integer> yobareta = new TreeSet<>();

        int q = nextInt();
        while (q --> 0) {
            int e = nextInt();
            if (e == 1) {
                Integer first = taiki.pollFirst();
                yobareta.add(first);
            } else if (e == 2) {
                int x = nextInt();
                yobareta.remove(x);
            } else if (e == 3) {
                Integer first = yobareta.first();
                out.println(first);
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