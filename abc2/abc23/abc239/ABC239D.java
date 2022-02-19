import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC239D {

    public static void main(String[] args) {
        boolean[] primes = new boolean[201];
        Arrays.fill(primes, true);
        primes[0]= false;
        primes[1]= false;
        for (int i = 2; i <= 200; i++) {
            if (primes[i]) {
                for (int j = i*2; j <= 200; j+=i) {
                    primes[j]=false;
                }
            }
        }

        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();

        boolean Aoki = true;
        for (int i = a; i <= b; i++) {
            boolean any = false;
            for (int j = c; j <= d; j++) {
                any = any || primes[i+j];
            }
            Aoki = Aoki && any;
        }
        out.println(Aoki?"Aoki":"Takahashi");
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