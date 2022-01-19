import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC058C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            char[] s = next().toCharArray();
            int[] scount = new int[26];
            for (char c : s) {
                scount[c-'a']++;
            }
            for (int j = 0; j < 26; j++) {
                count[j] = Math.min(count[j], scount[j]);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            ans.append(Character.toString('a'+i).repeat(count[i]));
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