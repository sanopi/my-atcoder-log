import java.io.PrintWriter;
import java.util.Scanner;

public class ABC264B {

    public static void main(String[] args) {
        int r = nextInt()-1;
        int c = nextInt()-1;
        String[] s = {
            "bbbbbbbbbbbbbbb",
            "bwwwwwwwwwwwwwb",
            "bwbbbbbbbbbbbwb",
            "bwbwwwwwwwwwbwb",
            "bwbwbbbbbbbwbwb",
            "bwbwbwwwwwbwbwb",
            "bwbwbwbbbwbwbwb",
            "bwbwbwbwbwbwbwb",
            "bwbwbwbbbwbwbwb",
            "bwbwbwwwwwbwbwb",
            "bwbwbbbbbbbwbwb",
            "bwbwwwwwwwwwbwb",
            "bwbbbbbbbbbbbwb",
            "bwwwwwwwwwwwwwb",
            "bbbbbbbbbbbbbbb",
        };
        if (s[r].charAt(c) == 'w') {
            out.println("white");
        } else {
            out.println("black");
        }
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