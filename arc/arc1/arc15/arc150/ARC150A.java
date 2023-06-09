import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class ARC150A {

    public static void main(String[] args) {
        int t = nextInt();
        Map<Character, Integer> c2i = Map.of(
            '0',0,
            '1',1,
            '?',2
        );

        while (t --> 0) {
            int n = nextInt();
            int k = nextInt();
            String s = next();
            int[] count = new int[3];
            for (int i = 0; i < k-1; i++) {
                count[c2i.get(s.charAt(i))]++;
            }
            int[] otherCount = new int[3];
            for (int i = k-1; i < n; i++) {
                otherCount[c2i.get(s.charAt(i))]++;
            }
            int l = 0;
            int okCount = 0;
            while (l <= n-k) {
                count[c2i.get(s.charAt(l+k-1))]++;
                otherCount[c2i.get(s.charAt(l+k-1))]--;

                if (count[0]==0 && otherCount[1]==0) {
                    okCount++;
                }
                count[c2i.get(s.charAt(l))]--;
                otherCount[c2i.get(s.charAt(l))]++;
                l++;
            }
            out.println(okCount==1?"Yes":"No");
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