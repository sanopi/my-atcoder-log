import java.io.PrintWriter;
import java.util.Scanner;

public class ABC279E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = nextInt()-1;
        }

        Pair[] pairs = new Pair[m];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i+1;
        }
        for (int i = 0; i < m; i++) {
            pairs[i] = new Pair(b[a[i]], b[a[i]+1]);
            int tmp = b[a[i]+1];
            b[a[i]+1] = b[a[i]];
            b[a[i]] = tmp;
        }

        int[] indice = new int[n+1];
        for (int i = 0; i < n; i++) {
            indice[b[i]] = i+1;
        }

        for (int i = 0; i < m; i++) {
            if (pairs[i].l == 1) {
                out.println(indice[pairs[i].r]);
            } else if (pairs[i].r == 1) {
                out.println(indice[pairs[i].l]);
            } else {
                out.println(indice[1]);
            }
        }

        out.flush();
    }

    private static class Pair {
        int l;
        int r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
        @Override
        public String toString() {
            return "Pair{" +
                "l=" + l +
                ", r=" + r +
                '}';
        }
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