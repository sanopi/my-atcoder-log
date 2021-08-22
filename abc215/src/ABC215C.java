import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC215C {

    static String[] ss;
    static List<String> all;
    static boolean[] used;
    static int len;

    public static void main(String[] args) {
        String s = next();
        int k = nextInt();

        len = s.length();
        ss = s.split("");
        all = new ArrayList<>();
        used = new boolean[len];

        per("");
        out.println(all.stream().distinct().sorted().collect(Collectors.toList()).get(k-1));

        out.flush();
    }

    private static void per(String med) {
        if (med.length() == len) {
            all.add(med);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) continue;
            used[i] = true;
            per(med+ss[i]);
            used[i] = false;
        }
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