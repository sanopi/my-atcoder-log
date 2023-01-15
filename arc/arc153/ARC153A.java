import java.io.PrintWriter;
import java.util.Scanner;

public class ARC153A {

    public static void main(String[] args) {
        int n = nextInt();
        String ns = Integer.toString(n+100000-1);
        char[] ans = new char[9];
        ans[0]=ns.charAt(0);
        ans[1]=ns.charAt(0);
        ans[2]=ns.charAt(1);
        ans[3]=ns.charAt(2);
        ans[4]=ns.charAt(3);
        ans[5]=ns.charAt(3);
        ans[6]=ns.charAt(4);
        ans[7]=ns.charAt(5);
        ans[8]=ns.charAt(4);
        out.println(String.valueOf(ans));
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