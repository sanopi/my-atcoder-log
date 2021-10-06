import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC221C {

    public static void main(String[] args) {
        char[] n = next().toCharArray();
        out.println(solve1(n));
        out.flush();
//        for (int i = 11; i < 1000000000; i++) {
//            char[] n = String.valueOf(i).toCharArray();
//            int count = 0;
//            for (int j = 0; j < n.length; j++) {
//                if (n[j] != '0') {
//                    count++;
//                }
//            }
//            if (count >= 2) {
//                long ans0 = solve0(n);
//                long ans1 = solve1(n);
//                if (ans0 != ans1) {
//                    System.out.println("ans0: " + ans0 + ", ans1: " + ans1);
//                }
//            }
//        }
    }

    private static long solve0(char[] n) {
        Arrays.sort(n);

        int max = 0;
        for (int i = 0; i < (1 << n.length); i++) {
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int j = 0; j < n.length; j++) {
                if ((i & (1 << j)) == 0) {
                    a.append(n[n.length - j - 1]);
                } else {
                    b.append(n[n.length - j - 1]);
                }
            }
            String as = a.toString();
            String bs = b.toString();
            if (as.length() > 0 && bs.length() > 0) {
                max = Math.max(max, Integer.parseInt(as) * Integer.parseInt(bs));
            }
        }

        return max;
    }

    /**
     * 今をa,bとして、次をx、その次をyとした時、（x,yはソート済）
     * (10a + x)b >= (10b + x)a...⓪
     * であるならば
     * (10(10a + x) + y)b...① もしくは (10b + y)(10a + x)...② の少なくとも一方が
     * (10a + y)(10b + x)...③ と (10(10b + x) + y)a...④ の両方以上であることを示したい。（そうすれば帰納的に示せそう）
     * ①=>100ab+10bx+by
     * ②=>100ab+10ay+10bx+xy
     * ③=>100ab+10ax+10by+xy
     * ④=>100ab+10ax+ay
     *
     * ②-③=10ay+10bx-(10ax+10by)=10(ay+bx-ax-by)=10(a-b)(y-x)
     * ⓪=> 10ab+bx>=10ab+ax => bx>=ax => b>=a なので、
     * a-b<=0, y-x<=0（ソート済のため）
     * ∴②-③>=0
     *
     * ②-④=10ay+10bx+xy-10ax-ay = 9ay+10bx+xy-10ax = 9ay+x(10b-10a+y) >= 9ay+x(10a-10a+y) > 0
     *
     * ②が③と④以上であることが分かった。
     */
    private static long solve1(char[] n) {
        Arrays.sort(n);
        long a = n[n.length-1]-'0';
        long b = n[n.length-2]-'0';
        if (n.length == 2) {
            return a * b;
        }
        for (int i = n.length - 3; i >= 0; i--) {
            if ((10 * a + n[i]) * b > (10 * b + n[i]) * a) {
                a = 10 * a + n[i]-'0';
            } else {
                b = 10 * b + n[i]-'0';
            }
        }

        return a * b;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

}