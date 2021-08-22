import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC215D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);
        int max = 100000;

        int[] spf = new int[max+1];
        for (int i = 0; i <= max; i++) {
            spf[i] = i;
        }
        for (int i = 2; i <= max; i++) {
            if (spf[i] == i) {
                if ((long)i * (long)i > max) {
                    continue;
                }
                for (int j = i * i; j <= max; j+=i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }


        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ai = a[i];
            while (true) {
                int tmp = spf[ai];
                if (tmp <= m) {
                    s.add(tmp);
                }
                ai /= tmp;
                if (ai == 1) {
                    break;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 2; i <= m; i++) {
            int ii = i;
            boolean ok = true;
            while (true) {
                int tmp = spf[ii];
                if (s.contains(tmp)) {
                    ok = false;
                }
                ii /= tmp;
                if (ii == 1) {
                    break;
                }
            }
            if(ok) ans.add(i);
        }
        out.println(ans.size());
        ans.forEach(out::println);
        out.flush();
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