import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC076C {

    public static void main(String[] args) {
        String s = next();
        String t = next();
        Set<String> candidates = new HashSet<>();
        for (int i = 0; i <= s.length() - t.length(); i++) {
            int si = i;
            int ti = 0;
            while (ti < t.length() && (s.charAt(si) == '?' || s.charAt(si) == t.charAt(ti))) {
                si++;
                ti++;
            }
            if (ti == t.length()) {
                char[] chars = s.toCharArray();
                for (int j = i; j < i+t.length(); j++) {
                    chars[j] = t.charAt(j-i);
                }
                candidates.add(String.valueOf(chars));
            }
        }
        out.println(candidates.stream().map(str -> str.replaceAll("\\?", "a")).min(Comparator.naturalOrder()).orElse("UNRESTORABLE"));
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