import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC257E {

    public static void main(String[] args) {
        int n = nextInt();
        int[] c = nextIntArray(9);
        int min = Arrays.stream(c).min().getAsInt();
        int count = n / min;
        int rest = n % min;

        if (count==0) {
            System.out.println(0);
            return;
        }

        int minI = -1;
        for (int i = 9 - 1; i >= 0; i--) {
            if (c[i] == min) {
                minI = i+1;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 9;
        while (rest > 0 && c[i-1]>min) {
            if (c[i-1]-min <= rest) {
                sb.append(i);
                rest -= c[i-1]-min;
            } else {
                i--;
            }
        }

        sb.append(String.valueOf(minI).repeat(count-sb.length()));
        out.println(sb);
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