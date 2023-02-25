import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ARC157B {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        char[] s = next().toCharArray();
        int xCount = 0;
        int yCount = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'X') {
                xCount++;
            } else {
                yCount++;
            }
        }

        if (yCount == 0) {
            System.out.println(Math.max(0, k-1));
            return;
        }

        if (xCount == 0) {
            System.out.println(Math.max(0, n - 1 - k));
            return;
        }

        if (xCount<k) {
            k = yCount - (k-xCount);
            for (int i = 0; i < n; i++) {
                if (s[i] == 'X') {
                    s[i] = 'Y';
                } else {
                    s[i] = 'X';
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            if (s[i]=='Y' && s[i+1] == 'Y') {
                ans++;
            }
        }

        List<C> list = new ArrayList<>();
        list.add(new C(s[0], 1, true));
        for (int i = 1; i < n; i++) {
            char si = s[i];
            C last = list.get(list.size() - 1);
            if (last.c == si) {
                last.count++;
            } else {
                list.add(new C(si, 1, false));
            }
        }
        list.get(list.size()-1).edge = true;

        list.sort(Comparator.comparing((C c) -> c.edge).thenComparing(c -> c.count));

        for (int i = 0; i < list.size() && k > 0; i++) {
            C ci = list.get(i);
            if (ci.c == 'Y') continue;
            if (ci.count <= k) {
                ans += ci.count + (ci.edge ? 0 : 1);
            } else {
                ans += k;
            }
            k-=ci.count;
        }

        out.println(ans);
        out.flush();
    }

    private static class C {
        int c;
        int count;
        boolean edge;
        public C(int c, int count, boolean edge) {
            this.c = c;
            this.count = count;
            this.edge = edge;
        }
        @Override
        public String toString() {
            return "C{" +
                "c=" + c +
                ", count=" + count +
                ", edge=" + edge +
                '}';
        }
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