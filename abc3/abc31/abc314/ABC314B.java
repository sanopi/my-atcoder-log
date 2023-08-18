import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.Set;

public class ABC314B {

    public static void main(String[] args) {
        int n = nextInt();
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < n; i++) {
            int c = nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < c; j++) {
                set.add(nextInt());
            }
            sets[i] = set;
        }
        int x = nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (sets[i].contains(x)) {
                list.add(i);
            }
        }
        OptionalInt min = list.stream().mapToInt(i -> sets[i].size()).min();
        if (min.isEmpty()) {
            System.out.println(0);
            System.out.println();
            return;
        }
        int min1 = min.getAsInt();
        List<Integer> ans = list.stream().filter(i -> sets[i].size() == min1).sorted(Comparator.naturalOrder()).toList();
        out.println(ans.size());
        for (Integer an : ans) {
            out.print(an+1 + " " );
        }
        out.println();
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