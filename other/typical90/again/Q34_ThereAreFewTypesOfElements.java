package again;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q34_ThereAreFewTypesOfElements {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);

        int ans = 0;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a[0], 1);
        while (r < n) {
            ans = Math.max(ans, r-l+1);
            if (map.size()<=k) {
                r++;
                if (r<n) map.put(a[r], map.getOrDefault(a[r], 0)+1);
            }
            while (map.size()>k) {
                map.put(a[l], map.get(a[l])-1);
                map.remove(a[l], 0);
                l++;
            }
        }
        out.println(ans);
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