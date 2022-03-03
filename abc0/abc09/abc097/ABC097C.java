import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC097C {

    public static void main(String[] args) {
        String s = next();
        int k = nextInt();

        List<String> rec = rec(s, k);
        rec.sort(Comparator.naturalOrder());
        out.println(rec.get(k-1));

        out.flush();
    }

    private static List<String> rec(String s, int k) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            int index = s.indexOf(c);
            if (index==-1) continue;
            for (int j = 1; j <= k; j++) {
                if (index+j<=s.length()) {
                    res.add(s.substring(index, index+j));
                }
            }
            res.addAll(rec(s.substring(index+1), k));
            res = res.stream().distinct().collect(Collectors.toList());
            if (res.size()>=k) {
                break;
            }
        }
        return res.stream().sorted().limit(k).collect(Collectors.toList());
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