import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC084D {

    public static void main(String[] args) {
        int MAX = 100000;
        int[] sum = new int[MAX+1];
//        createSum(MAX, sum);
        createSum2(MAX, sum);
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            int l = nextInt();
            int r = nextInt();
            out.println(sum[r]-sum[l-1]);
        }
        out.flush();
    }
    private static void createSum2(int max, int[] sum) {
        boolean[] primes = new boolean[max+1];
        Arrays.fill(primes, true);
        for (int i = 2; i <= max; i++) {
            if (primes[i]) {
                for (int j = i*2; j <= max; j+=i) {
                    primes[j]=false;
                }
            }
        }
        for (int i = 2; i <= max; i++) {
            sum[i] = sum[i-1]+ (i%2==1&&primes[i]&&primes[(i+1)/2]?1:0);
        }
    }

    private static void createSum(int MAX, int[] sum) {
        for (int i = 3; i <= MAX; i++) {
            sum[i]= sum[i-1]+(isOk(i)?1:0);

        }
    }

    private static boolean isOk(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i==0) return false;
        }
        n = (n + 1) / 2;
        for (int i = 2; i*i <= n; i++) {
            if (n%i==0) return false;
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