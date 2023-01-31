import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ARC144B {

    public static void main(String[] args) {
        int n = nextInt();
        long a = nextInt();
        long b = nextInt();
        long[] array = nextLongArray(n);
        Arrays.sort(array);
        long ok = array[0];
        long ng = Integer.MAX_VALUE;
        while (ng - ok > 1) {
            long mid = (ok+ng)/2;
            // minを、mid 以上にできるか
//            long[] newArray = Arrays.copyOf(array, array.length);
            long count = 0;
            for (int i = 0; i < n; i++) {
                long ai = array[i];
                if (ai >= mid) {
                    break;
                }
                long k = ((mid-ai + a -1) /a);
                count+=k;
            }
            Arrays.sort(array);
            for (int i = n - 1; i >= 0; i--) {
                long ai = array[i];
                if (ai-b < mid) {
                    break;
                }
                long k = ((ai-mid) / b);
                count-=k;
            }
            if (count<=0) {
                ok = mid;
            } else{
                ng = mid;
            }
        }
        out.println(ok);
        out.flush();
    }

    private static void TLE(int n, int a, int b, int[] array) {
        TreeMap<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put((long) array[i], map.getOrDefault((long) array[i], 0) + 1);
        }
        long ans = map.firstKey();

        while (true) {
            Map.Entry<Long, Integer> first = map.pollFirstEntry();
            long newFirst = first.getKey() + a;
            if (first.getValue()-1 != 0) {
                map.put(first.getKey(), first.getValue()-1);
            }

            Map.Entry<Long, Integer> last = map.pollLastEntry();
            long newLast = last.getKey() - b;
            if (last.getValue()-1 != 0) {
                map.put(last.getKey(), last.getValue()-1);
            }

            if (newFirst == last.getKey() && newLast == first.getKey()) {
                break;
            }

            map.put(newFirst, map.getOrDefault(newFirst, 0)+1);
            map.put(newLast, map.getOrDefault(newLast, 0)+1);

            long newAns = map.firstKey();
            if (newAns < ans) {
                break;
            }
            ans = newAns;
        }
        out.println(ans);
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