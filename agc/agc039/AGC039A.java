import java.io.PrintWriter;
import java.util.Scanner;

public class AGC039A {

    public static void main(String[] args) {
        String s = next();
        int n = s.length();
        long k = nextLong();

        boolean allSame = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                allSame = false;
                break;
            }
        }
        if (allSame) {
            System.out.println(n*k/2);
            return;
        }

//        solve1(s, k);
        solve2(s, k);
        out.flush();
    }
    private static void solve2(String s, long k) {
        int count1 = 0;
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length-1; i++) {
            if (sc[i] == sc[i+1]) {
                sc[i+1] = ' ';
                count1++;
            }
        }
        int count2 = 0;
        char[] ss = s.repeat(2).toCharArray();
        for (int i = 0; i < ss.length-1; i++) {
            if (ss[i] == ss[i+1]) {
                ss[i+1] = ' ';
                count2++;
            }
        }
        int diff = count2 - count1;
        out.println(count1+diff*(k-1));
    }
    private static void solve1(String s, long k) {
        int n = s.length();
        char[] ss = s.repeat(3).toCharArray();
        for (int i = 0; i < ss.length-1; i++) {
            if (ss[i] == ss[i+1]) {
                ss[i+1] = ' ';
            }
        }
        int[] counts = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                int l = n *i+j;
                if (ss[l] == ' ') {
                    counts[i]++;
                }
            }
        }
        out.println(counts[0] + Math.max(k -2, 0)*counts[1] + Math.min(k -1, 1)*counts[2]);
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