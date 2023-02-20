import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC290E {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = nextIntArray(n);
        List<Integer>[] indice = new List[n+1];
        for (int i = 0; i < n + 1; i++) {
            indice[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            indice[a[i]].add(i);
        }
        long minus = 0;
        for (int i = 0; i < n + 1; i++) {
            List<Integer> indexes = indice[i];
            int size = indexes.size();
            long[] sum = new long[size+1];
            for (int j = 0; j < size; j++) {
                sum[j+1] = sum[j] + (n-indexes.get(j));
            }

            for (int j = 0; j < size; j++) {
                int found = upperBound(indexes, n - 1 - indexes.get(j));
                minus += Math.max(0, (long)(found-1 - j) * (indexes.get(j)+1));
                minus += sum[size]-sum[Math.max(j+1, found)];
            }
        }

        long total = 0;
        for (int i = 0; i <= n; i++) {
            total += (long) (n + 1 - i) *(i/2);
        }

        out.println(total-minus);
        out.flush();
    }

    private static int upperBound(List<Integer> a, int key) {
        int ok = a.size();
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a.get(mid)) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
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