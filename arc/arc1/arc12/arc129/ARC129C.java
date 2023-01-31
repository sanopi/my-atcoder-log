import java.io.PrintWriter;
import java.util.Scanner;

public class ARC129C {

    public static void main(String[] args) {
        int n = nextInt();

        solve(n);
        out.flush();
    }
    private static void solve(int n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int[] lastCounts = new int[7];
        int num = 7;
        while (true) {
            int[] tmp = new int[7];
            for (int i = 0; i < 7; i++) {
                tmp[(i*10+num)%7] += lastCounts[i];
            }
            tmp[num%7]++;
            int next = count + tmp[0];
            if (next == n) {
                sb.append(num);
                break;
            }
            if (next < n) {
                sb.append(num);
                count = next;
                lastCounts = tmp;
                num = 7;
            }
            if (next > n) {
                num = (num+1)%10;
                if (num == 0) {
                    num = 1;
                }
                continue;
            }
        }

        out.println(sb.toString());
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