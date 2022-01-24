import java.io.PrintWriter;
import java.util.Scanner;

public class ABC128C {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Light[] lights = new Light[m];
        for (int i = 0; i < m; i++) {
            int k = nextInt();
            int[] ss = new int[k];
            for (int j = 0; j < k; j++) {
                ss[j] = nextInt()-1;
            }
            lights[i] = new Light(k, ss);
        }
        int[] p = nextIntArray(m);

        int count = 0;
        for (int i = 0; i < 1 << n; i++) {
            boolean[] onSwitch = new boolean[n];
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) != 0) onSwitch[j] = true;
            }
            boolean isOk = true;
            for (int j = 0; j < m; j++) {
                int onCount = 0;
                for (int l = 0; l < lights[j].k; l++) {
                    if (onSwitch[lights[j].ss[l]]) onCount++;
                }
                isOk &= (onCount % 2 == p[j]);
            }
            if (isOk) count++;
        }
        out.println(count);
        out.flush();
    }

    private static class Light {
        int k;
        int[] ss;
        public Light(final int k, final int[] ss) {
            this.k = k;
            this.ss = ss;
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