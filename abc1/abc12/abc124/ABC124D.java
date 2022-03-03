import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC124D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        String s = next();

        int current = s.charAt(0)-'0';
        int count = 0;
        List<Integer> blockNum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (current == s.charAt(i)-'0') {
                count++;
            } else {
                blockNum.add(count);
                count = 1;
                current = 1-current;
            }
        }
        blockNum.add(count);
        int[] sum = new int[blockNum.size()+1];
        for (int i = 1; i <= blockNum.size(); i++) {
            sum[i] = sum[i-1]+blockNum.get(i-1);
        }

        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            if (i%2 != s.charAt(0)-'0') {
                ans = Math.max(ans, sum[Math.min(sum.length-1, i+2*k-1)]-sum[i-1]);
            } else {
                ans = Math.max(ans, sum[Math.min(sum.length-1, i+2*k)]-sum[i-1]);
            }
        }
        out.println(ans);

        out.flush();
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