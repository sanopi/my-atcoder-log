import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC351E {


    private static void solve() {
        int n = nextInt();
        List<P> ps1 = new ArrayList<>();
        List<P> ps2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = nextInt();
            int y = nextInt();
            if ((x+y)%2 == 0) {
                ps1.add(new P(x,y));
            } else {
                ps2.add(new P(x,y));
            }
        }
        out.println(calc(ps1) + calc(ps2));
        out.flush();
    }

    private static long calc(List<P> ps) {
        List<P> pds = new ArrayList<>();
        for (P p : ps) {
            long x = p.x;
            long y = p.y;
            long xx = x + y;
            long yy = x-y;
            pds.add(new P(xx, yy));
        }
        long res = 0;
        int n = pds.size();
        pds.sort(Comparator.comparing(pd -> pd.x));
        for (int i = 1; i < n; i++) {
            P to = pds.get(i);
            P from = pds.get(i-1);
            res += Math.abs(to.x-from.x)*(n-i)*i;
        }
        pds.sort(Comparator.comparing(pd -> pd.y));
        for (int i = 1; i < n; i++) {
            P to = pds.get(i);
            P from = pds.get(i-1);
            res += Math.abs(to.y-from.y)*(n-i)*i;
        }
        return res/2;
    }

    private static class P {
        long x;
        long y;
        public P(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

//    private static class PD {
//        double x;
//        double y;
//        public PD(double x, double y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

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