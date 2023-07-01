import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC307D {

    public static void main(String[] args) {
        int n = nextInt();
        String s = next();
        Deque<Character> deque = new ArrayDeque<>();
        int sCount = 0;
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            if (si == '(') {
                deque.addLast(si);
                sCount++;
            } else if (si == ')') {
                if (sCount>0) {
                    while (deque.pollLast() != '(') {}
                    sCount--;
                } else {
                    deque.addLast(si);
                }
            } else {
                deque.addLast(si);
            }
        }
        StringBuilder ans = new StringBuilder();
        deque.forEach(ans::append);
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