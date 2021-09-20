import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC219C {

    private static Map<Character, Integer> map;

    public static void main(String[] args) {
        String x = next();
        map = new HashMap<>();
        char[] chars = x.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }
        int n = nextInt();

        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
        }

        Arrays.sort(s, ((s1, s2) -> compare(s1, s2)));
        for (final String s1 : s) {
            out.println(s1);
        }
        out.flush();
    }

    static int compare(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < min; i++) {
            if (map.get(c1[i]).equals(map.get(c2[i]))) {
                continue;
            }
            return map.get(c1[i]).compareTo(map.get(c2[i]));
        }
        return Integer.compare(s1.length(), s2.length());
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}