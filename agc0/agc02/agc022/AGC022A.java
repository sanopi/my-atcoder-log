import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AGC022A {

    public static void main(String[] args) {
        String s = next();
        s+=(char)('a'-1);
        int n = s.length();
        Set<Character>[] done = new Set[n];
        done[0] = Set.of();
        for (int i = 1; i < n; i++) {
            done[i] = new HashSet<>(done[i-1]);
            done[i].add(s.charAt(i-1));
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = s.charAt(i)-'a'+1; j < 26; j++) {
                char c = (char) (j + 'a');
                if (!done[i].contains(c)) {
                    System.out.println(s.substring(0, i)+c);
                    return;
                }
            }
        }
        System.out.println(-1);
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