import java.io.PrintWriter;
import java.util.Scanner;

public class JSC2019QualB {

    private static int MOD = 1000000007;

    public static void main(String[] args) {
        int n = nextInt();
        long k = nextInt();
        int[] a = nextIntArray(n);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i]>a[j]) {
                    ans++;
                }
            }
        }
        ans*=k;
        ans%=MOD;

        int[] counts = new int[2001];
        for (int i = 0; i < n; i++) {
            counts[a[i]]++;
        }
        int[] seeds = new int[2002];
        for (int i = 1; i < 2002; i++) {
            seeds[i] = seeds[i-1]+counts[i-1];
        }

        for (int i = 0; i < n; i++) {
            ans+= (k * (k - 1)) / 2 % MOD * seeds[a[i]] % MOD;
            ans%=MOD;
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