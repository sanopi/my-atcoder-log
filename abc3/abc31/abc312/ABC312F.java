import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class ABC312F {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Long> zero = new ArrayList<>();
        List<Long> one = new ArrayList<>();
        List<Long> two = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = nextInt();
            long x = nextInt();
            if (t == 0) zero.add(x);
            else if (t == 1) one.add(x);
            else two.add(x);
        }
        zero.sort(Comparator.reverseOrder());
        one.sort(Comparator.reverseOrder());
        two.sort(Comparator.reverseOrder());
        Deque<Long> qZero = new ArrayDeque<>();
        Deque<Long> qOne = new ArrayDeque<>();
        Deque<Long> qTwo = new ArrayDeque<>();
        qOne.addAll(one);
        qTwo.addAll(two);

        long s = 0;
        int used = 0;
        for (int i = 0; i < Math.min(m, zero.size()); i++) {
            Long zi = zero.get(i);
            s+=zi;
            qZero.addFirst(zi);
            used++;
        }

        long ans = s;
        long stock = 0;
        while (true) {
            if (stock == 0) {
                if (qTwo.isEmpty()) break;
                Long cankiri = qTwo.poll();
                stock += cankiri;
                used++;
            }
            if (qOne.isEmpty()) break;
            Long need = qOne.poll();
            s+=need;
            used++;
            stock--;

            while (used > m && !qZero.isEmpty()) {
                Long z = qZero.poll();
                s-=z;
                used--;
            }
            if (used <= m) {
                ans = Math.max(ans, s);
            }
        }
        out.println(ans);
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