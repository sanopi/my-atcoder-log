import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC321C {

    private static List<String> can = new ArrayList<>();

    private static void solve() {
        int k = nextInt();
        for (int i = 1; i <= 9; i++) {
            make(Integer.toString(i));
            can.add(Integer.toString(i));
        }
        can.sort(Comparator.comparing(s -> Long.valueOf(s)));
        out.println(can.get(k - 1));
        out.flush();
    }

    private static void make(String s) {
        int i = s.charAt(s.length()-1)-'0';
        for (int j = 0; j < i; j++) {
            String ns = s+j;
            can.add(ns);
            make(ns);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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