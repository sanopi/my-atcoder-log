import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ABC142D {

    public static void main(String[] args) {
        long a = nextLong();
        long b = nextLong();
        long gcd = gcd(a, b);
        Map<Long, Integer> elems = new HashMap<>();
        elems.put(1L, 1);
        for (long i = 2; (i*i) < gcd; i++) {
            while (gcd%i==0) {
                elems.put(i, elems.getOrDefault(i, 0)+1);
                gcd/=i;
            }
        }
        elems.put(gcd, elems.getOrDefault(gcd, 0)+1);

        out.println(elems.size());
        out.flush();
    }

    private static long gcd(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a%b);
    }

    private static List<Long> getDivisors(long l) {
        Map<Long, Integer> elems = new HashMap<>();
        for (long i = 2; (i*i) < l; i++) {
            while (l%i==0) {
                elems.put(i, elems.getOrDefault(i, 0)+1);
                l/=i;
            }
        }
        elems.put(l, elems.getOrDefault(l, 0)+1);
        List<Long> res = new ArrayList<>();
        res.add(1L);
        for (Map.Entry<Long, Integer> entry : elems.entrySet()) {
            List<Long> newRes = new ArrayList<>();
            int count = entry.getValue();
            long value = 1L;
            while (count >= 0) {
                for (long resElem : res) {
                    newRes.add(resElem * value);
                }
                value*=entry.getKey();
                count--;
            }
            res=newRes;
        }
        return res;
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