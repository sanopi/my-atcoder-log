import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class ABC297E {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        long[] a = nextLongArray(n);
        Arrays.sort(a);
        Set<Long> done = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            if (done.contains(ai)) continue;
            done.add(ai);
            pq.add(ai);
        }

        while (list.size()<k) {
            Long current = pq.poll();
            list.add(current);

            for (int i = 0; i < n; i++) {
                long ai = a[i];
                long next = current + ai;
                if (done.contains(next)) continue;
                done.add(next);

                pq.add(next);
            }
        }
        out.println(list.get(k-1));
        out.flush();
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