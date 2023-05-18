import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC301C {

    public static void main(String[] args) {
        String s = next();
        String t = next();
        int[] slCount = new int[26];
        int sAtCount = 0;
        int[] tlCount = new int[26];
        int tAtCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char si = s.charAt(i);
            if (si == '@') {
                sAtCount++;
            } else {
                slCount[si-'a']++;
            }
            char ti = t.charAt(i);
            if (ti == '@') {
                tAtCount++;
            } else {
                tlCount[ti-'a']++;
            }
        }

        List<Character> atcoder = new ArrayList<>();
        for (char c : "atcoder".toCharArray()) {
            atcoder.add(c);
        }

        int sOver = 0;
        int tOver = 0;
        for (int i = 0; i < 26; i++) {
            int sc = slCount[i];
            int tc = tlCount[i];
            if (atcoder.contains((char)(i+'a'))) {
                sOver += Math.max(0, sc-tc);
                tOver += Math.max(0, tc-sc);
            } else {
                if (sc != tc) {
                    System.out.println("No");
                    return;
                }
            }
        }
        if (sOver <= tAtCount && tOver <= sAtCount) {
            out.println("Yes");
        } else {
            out.println("No");
        }

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