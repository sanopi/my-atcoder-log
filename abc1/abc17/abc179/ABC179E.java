import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC179E {

    public static void main(String[] args) {
        long n = nextLong();
        int x = nextInt();
        int m = nextInt();

        int[] indice = new int[m+1];
        Arrays.fill(indice, -1);
        long[] sum = new long[m+2];
        sum[1] = x;
        int i = 0;
        while (indice[x] == -1 && i < n) {
            indice[x] = i;
            x = (int) ((long)x * x % m);
            i++;
            sum[i+1] = x+sum[i];
        }

        if (i == n) {
            System.out.println(sum[i]);
            return;
        }

        int cycle = i-indice[x];
        long cycleSum = sum[i]-sum[indice[x]];

        long ans = sum[indice[x]];
        n -= indice[x];
        ans += cycleSum * (n/cycle);
        n %= cycle;
        ans += sum[indice[x]+(int)n] - sum[indice[x]];

        out.println(ans);
        out.flush();
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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