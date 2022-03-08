import java.io.PrintWriter;
import java.util.Scanner;

public class ABC112C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = nextInt();
            y[i] = nextInt();
            h[i] = nextInt();
        }

        for (int cx = 0; cx <= 100; cx++) {
            for (int cy = 0; cy <= 100; cy++) {
                Integer H = null;
                int hMax = Integer.MAX_VALUE;
                boolean ok = true;
                for (int i = 0; i < n; i++) {
                    int ch = Math.abs(x[i] - cx) + Math.abs(y[i] - cy);
                    if (h[i] == 0) {
                        hMax = Math.min(hMax, ch);
                    } else {
                        if (H == null) {
                            H = h[i]+ch;
                        } else {
                            if (H != h[i]+ch) {
                                ok=false;
                                break;
                            }
                        }
                    }
                }
                if(!ok) continue;
                if(H>hMax) continue;
                System.out.println(cx+" "+ cy+" "+H);
                return;
            }
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