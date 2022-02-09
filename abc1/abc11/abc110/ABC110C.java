import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ABC110C {

    public static void main(String[] args) {
        String s = next();
        String t = next();
        List<Integer>[] sCharIndice = new List[26];
        List<Integer>[] tCharIndice = new List[26];
        for (int i = 0; i < 26; i++) {
            sCharIndice[i] = new ArrayList<>();
            tCharIndice[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            sCharIndice[s.charAt(i)-'a'].add(i);
            tCharIndice[t.charAt(i)-'a'].add(i);
        }
        Arrays.sort(sCharIndice, Comparator.comparing(l-> l.isEmpty()?Integer.MAX_VALUE:l.get(0)));
        Arrays.sort(tCharIndice, Comparator.comparing(l-> l.isEmpty()?Integer.MAX_VALUE:l.get(0)));
        for (int i = 0; i < 26; i++) {
            if (!sCharIndice[i].equals(tCharIndice[i])) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
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