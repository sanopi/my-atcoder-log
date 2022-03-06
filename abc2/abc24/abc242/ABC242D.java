import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ABC242D {

    private static final Map<Character, List<Character>> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('A', List.of('B', 'C'));
        map.put('B', List.of('C', 'A'));
        map.put('C', List.of('A', 'B'));
//        System.out.println(Integer.toString(13, 2));
        String s = next();
        int q = nextInt();
        for (int i = 0; i < q; i++) {
            long t = nextLong();
            long k = nextLong();

            long kk = k;
            long tt = t;
            long a = 1;
            while (kk>1 && tt>0) {
                kk+=1;
                kk/=2;
                tt-=1;
                a*=2;
            }
            char current = s.charAt((int)kk-1);
            k=(a+k-1)%a;

            if (k>0) {
                String sk = Long.toString(k, 2);
                char[] kChars = sk.toCharArray();
                for (int j = 0; j < kChars.length; j++) {
                    current = map.get(current).get(kChars[j]-'0');
                    t--;
                }
            }
            for (int j = 0; j < t % 3; j++) {
                current = map.get(current).get(0);
            }
            out.println(current);
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