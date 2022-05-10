package again;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Q51_TypicalShop {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        long p = nextLong();
        long[] a = nextLongArray(n);
        Map<Integer, List<Long>> map = new HashMap<>();
        int m = n/2;
        for (int i = 0; i < 1 << m; i++) {
            long price = 0;
            for (int j = 0; j < m; j++) {
                if ((i & 1 << j) != 0) price += a[j];
            }
            int bitCount = Integer.bitCount(i);
            List<Long> list = map.getOrDefault(bitCount, new ArrayList<>());
            list.add(price);
            map.put(bitCount, list);
        }
        map.values().forEach(Collections::sort);


        long ans = 0;
        for (int i = 0; i < 1<<(n - m); i++) {
            long price = 0;
            for (int j = 0; j < n - m; j++) {
                if ((i & 1 << j) != 0) price += a[j+m];
            }

            int rest = k - Integer.bitCount(i);
            List<Long> list = map.get(rest);
            if (list == null || list.isEmpty()) continue;
            ans += upperBound(list, p-price);
        }

        out.println(ans);
        out.flush();
    }

    private static int upperBound(List<Long> list, long p) {
        int found = Collections.binarySearch(list, p+1);
        return found<0 ? ~found : found;
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