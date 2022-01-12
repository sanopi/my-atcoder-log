import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC011A {

    public static void main(String[] args) {
        int n = nextInt();
        int c = nextInt();
        int k = nextInt();
        int[] t = nextIntArray(n);
        Arrays.sort(t);

        int ans = 0;
        int pCount = 0;
        int i = 0;
        while (i<n) {
            int timeLimit = t[i]+k;
            while (pCount<c && i<n && t[i]<=timeLimit){
                pCount++;
                i++;
            }
            ans++;
            pCount=0;
        }
        out.println(ans);
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