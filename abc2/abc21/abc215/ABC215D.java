import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ABC215D {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[] a = nextIntArray(n);
        int max = 100000;

        int[] spf = getSmallestPrimeFactorArray(max);

        boolean[] hasNoCoFac = new boolean[m+1];
        Arrays.fill(hasNoCoFac, true);
        hasNoCoFac[0] = false;
        hasNoCoFac[1] = false;

        for (int i = 0; i < n; i++) {
            int ai = a[i];
            List<Integer> pf = new ArrayList<>();
            while (true) {
                int tmp = spf[ai];
                if (tmp <= m) {
                    pf.add(tmp);
                }
                ai /= tmp;
                if (ai == 1) {
                    break;
                }
            }
            for (Integer p : pf) {
                if(hasNoCoFac[p]) {
                    for (int j = p; j <= m; j+=p) {
                        hasNoCoFac[j] = false;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 2; i <= m; i++) {
            if (hasNoCoFac[i]) ans.add(i);
        }
        out.println(ans.size());
        ans.forEach(out::println);
        out.flush();
    }

    private static int[] getSmallestPrimeFactorArray(int size) {
        int[] spf = new int[size+1];
        for (int i = 0; i <= size; i++) {
            spf[i] = i;
        }
        for (int i = 2; i <= size; i++) {
            if (spf[i] == i) {
                if ((long)i * (long)i > size) {
                    continue;
                }
                for (int j = i * i; j <= size; j+=i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
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