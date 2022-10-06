import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC123D {

    public static void main(String[] args) {
        int x = nextInt();
        int y = nextInt();
        int z = nextInt();
        int k = nextInt();
        long[] a = nextLongArray(x);
        long[] b = nextLongArray(y);
        long[] c = nextLongArray(z);

        long[] ab = new long[x*y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ab[i*y+j] = (a[i] + b[j]);
            }
        }
        Arrays.sort(ab);
        long[] ans = new long[k*z+1];
        int i = 0;
        int kk = k;
        while (kk>0 && i<ab.length){
            for (int j = 0; j < z; j++) {
                ans[i*z+j] = (ab[ab.length-1-i]+c[j]);
            }
            i++;
            kk--;
        }


        Arrays.sort(ans);
        i = ans.length-1;
        while (k>0) {
            out.println(ans[i]);
            i--;
            k--;
        }
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
        return Long.parseLong(next());
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