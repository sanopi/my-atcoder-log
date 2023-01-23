import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC286F {

    public static void main(String[] args) {
        int[] elems = {4, 9, 5, 7, 11, 13, 17, 19, 23};
        int length = elems.length;
        int[] points = new int[length];
        for (int i = 0; i < length-1; i++) {
            points[i+1] = points[i] + elems[i];
        }

        int m = 108;
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = i+2;
        }
        for (int i = 0; i < length - 1; i++) {
            a[points[i+1]-1] = points[i]+1;
        }
        a[m-1] = points[length-1]+1;

        out.println(m);
        for (int i = 0; i < m; i++) {
            out.print(a[i] + " ");
        }
        out.println();
        out.flush();

        int[] b = nextIntArray(m);
        int[] rests = new int[length];
        for (int i = 0; i < length; i++) {
            int bpi = b[points[i]];
            int rest = ((bpi - 1 - points[i]) + elems[i]) % elems[i];
            rests[i] = rest;
        }

        int tmp = 23 * 19;
        List<Integer> tmps = new ArrayList<>();
        for (int i = rests[length-1]; i < tmp; i+=23) {
            tmps.add(i);
        }
        List<Integer> tmps2 = new ArrayList<>();
        for (Integer integer : tmps) {
            if (integer%19 == rests[length-2]) {
                tmps2.add(integer);
            }
        }
        List<Integer> ans = new ArrayList<>(1000000000/tmp);
        for (int i = tmps2.get(0); i <= 1000000000; i+=tmp) {
            ans.add(i);
        }

        for (int i = length - 3; i >= 0; i--) {
            int elem = elems[i];
            List<Integer> next = new ArrayList<>(ans.size()/elem);
            for (Integer candidate : ans) {
                if (candidate % elem == rests[i]) {
                    next.add(candidate);
                }
            }
            ans = next;
        }
        System.out.println(ans.get(0));
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