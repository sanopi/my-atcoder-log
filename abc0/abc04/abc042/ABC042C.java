import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC042C {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        List<Character> usable = new ArrayList<>(List.of('0','1','2','3','4','5','6','7','8','9'));
        for (int i = 0; i < k; i++) {
            usable.remove((Character) (char)(nextInt()+'0'));
        }

        while (!isValid(usable, n)) {
            n++;
        }
        out.println(n);
        out.flush();
    }

    private static boolean isValid(List<Character> usable, int n) {
        String sn = String.valueOf(n);
        for (int i = 0; i < sn.length(); i++) {
            if (!usable.contains(sn.charAt(i))) {
                return false;
            }
        }
        return true;
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