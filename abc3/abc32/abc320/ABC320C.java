import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ABC320C {

    private static void solve() {
        int m = nextInt();
        String s1 = next();
        String s2 = next();
        String s3 = next();
        String[] ss = {s1.repeat(3), s2.repeat(3), s3.repeat(3)};
        int ans = 1000;
        for (List<Integer> list : List.of(
            List.of(0, 1, 2),
            List.of(0, 2, 1),
            List.of(1, 0, 2),
            List.of(1, 2, 0),
            List.of(2, 0, 1),
            List.of(2, 1, 0)
        )) {
            for (int i = 0; i < 10; i++) {
                int current = -1;
                for (Integer integer : list) {
                    current = ss[integer].indexOf(String.valueOf(i), current+1);
                    if (current == -1) {
                        break;
                    }
                }
                if (current!=-1) {
                    ans = Math.min(ans, current);
                }
            }
        }

        out.println(ans == 1000 ? -1 : ans);
        out.flush();
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