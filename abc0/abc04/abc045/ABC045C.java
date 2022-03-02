import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC045C {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < 1 << (n - 1); i++) {
            List<Integer> divide = new ArrayList<>();
            divide.add(0);
            for (int j = 0; j < n-1; j++) {
                if ((i&(1<<j))!=0) {
                    divide.add(j+1);
                }
            }
            divide.add(n);
            List<String> adds = new ArrayList<>();
            for (int j = 1; j < divide.size(); j++) {
                adds.add(s.substring(divide.get(j-1), divide.get(j)));
            }
            ans += adds.stream().mapToLong(Long::parseLong).sum();
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