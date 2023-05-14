import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC299C {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        List<Len> list = new ArrayList<>();
        list.add(new Len(s.charAt(0), 1));
        for (int i = 1; i < n; i++) {
            char si = s.charAt(i);
            Len last = list.get(list.size() - 1);
            if (last.c == si) {
                last.len++;
            } else {
                list.add(new Len(si, 1));
            }
        }
        if (list.size() < 2) {
            System.out.println(-1);
            return;
        }
        int ans = list.stream().filter(len -> len.c == 'o').mapToInt(len -> len.len).max().orElse(0);
        out.println(ans);
        out.flush();
    }

    private static class Len {
        char c;
        int len;
        public Len(char c, int len) {
            this.c = c;
            this.len = len;
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