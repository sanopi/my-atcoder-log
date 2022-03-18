import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC105C {

    public static void main(String[] args) {
        int n = nextInt();
        if (n==0) {
            System.out.println(0);
            return;
        }
        List<String> ans = rec(n);
        StringBuilder sb = new StringBuilder();
        ans.forEach(sb::append);
        String s = sb.reverse().toString();
        out.println(s.substring(s.indexOf("1")));
        out.flush();
    }

    private static List<String> rec(int x) {
        if (x==0) {
            return List.of();
        }
        List<String> res = new ArrayList<>();
        if (Math.abs(x)%2==1) {
            x=x-1;
            res.add("1");
        } else {
            res.add("0");
        }
        if (Math.abs(x)%4!=0) {
            x=x+2;
            res.add("1");
        } else {
            res.add("0");
        }
        res.addAll(rec(x / 4));
        return res;
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