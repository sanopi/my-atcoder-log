import java.io.PrintWriter;
import java.util.Scanner;

public class ABC242E {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        long[] count = new long[1000000];
        count[0]=1;
        count[1]=26;
        count[2]=26;
        for (int i = 3; i < 1000000; i++) {
            count[i]=count[i-2]*26;
            count[i]%=MOD;
        }

        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            String s = next();
            char[] chars = s.toCharArray();
            long ans = 0;
            for (int j = 0; j < (n)/2; j++) {
                int rest = n - 2 * (j + 1);
                ans += (chars[j]-'A') * count[rest];
                ans%=MOD;
            }
            if (n%2==1) {
                ans += (chars[n/2]-'A');
            }

            String ss = s.substring(0, (n) / 2);
            StringBuilder sb = new StringBuilder();
            sb.append(ss);
            if (n%2==1) {
                ss += Character.toString(chars[n/2]);
            }
            ss += sb.reverse().toString();
            ans += ss.compareTo(s)<=0 ? 1: 0;
            ans%=MOD;
            out.println(ans);
        }
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