import java.io.PrintWriter;
import java.util.Scanner;

public class ABC084C {

    public static void main(String[] args) {
        int n = nextInt();
        Triple[] datas = new Triple[n];
        for (int i = 0; i < n - 1; i++) {
            int c = nextInt();
            int s = nextInt();
            int f = nextInt();
            datas[i] = new Triple(c,s,f);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1; j++) {
                Triple data = datas[j];
                if (ans[i]-data.s <= 0) {
                    ans[i] = data.s;
                } else {
                    ans[i]=(ans[i]-data.s+data.f-1)/data.f*data.f+data.s;
                }
                ans[i]+=data.c;
            }
        }
        for (int an : ans) {
            out.println(an);
        }
        out.flush();
    }

    private static class Triple {
        int c;
        int s;
        int f;
        public Triple(int c, int s, int f) {
            this.c = c;
            this.s = s;
            this.f = f;
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