import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ABC295D {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        int[][] counts = new int[n+1][10];
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            for (int j = 0; j < 10; j++) {
                counts[i+1][j] = counts[i][j];
            }
            counts[i+1][si-'0']++;
            counts[i+1][si-'0']%=2;
        }

        Map<List<Integer>, Integer> left = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j : counts[i+1]) {
                nums.add(j);
            }
            Integer count = left.getOrDefault(nums, 0);
            ans += count;

            List<Integer> adds = new ArrayList<>();
            for (int j : counts[i]) {
                adds.add(j);
            }
            left.put(adds, left.getOrDefault(adds, 0) + 1);
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