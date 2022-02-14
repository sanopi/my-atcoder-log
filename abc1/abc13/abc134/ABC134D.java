import java.io.PrintWriter;
import java.util.Scanner;

public class ABC134D {

    public static void main(String[] args) {
        int n = nextInt();
        boolean[] a = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            a[i+1] = nextInt()==1;
        }
        boolean[] ans = new boolean[n+1];
        for (int i = n; i >= 1; i--) {
            int baisuu = 0;
            for (int j = i; j <= n; j+=i) {
                if (ans[j]) baisuu++;
            }
            if ((baisuu%2==1) != a[i]) ans[i]=true;
        }
        int count = 0;
        for (boolean an : ans) {
            if(an)count++;
        }
        out.println(count);
        for (int i = 1; i < ans.length; i++) {
            if(ans[i]) out.print(i+" ");
        }
        out.println();

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