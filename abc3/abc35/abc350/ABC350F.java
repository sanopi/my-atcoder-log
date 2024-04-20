import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC350F {

    private static void solve() {
        String s = next();
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] pair = new int[n];
        Deque<Integer> pars = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                pars.addLast(i);
            } else if (chars[i] == ')') {
                Integer lastI = pars.pollLast();
                pair[i] = lastI;
                pair[lastI] = i;
            }
        }

        P pos = new P(')', '(', false);
        P neg = new P('(', ')', true);
        P[] ps = new P[] { pos, neg };
        int dir = 0;
        int index = 0;
        int count = 0;
        Deque<Memo> memo = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (count < n) {
            char ci = chars[index];
            if (ci == ps[dir].end) {
                Memo memo1 = memo.pollLast();
                index = memo1.index;
                dir = memo1.dir;
            } else if (ci == ps[dir].rev) {
                index = pair[index];
                memo.addLast(new Memo(dir, index));
                dir ^= 1;
            } else {
                sb.append(
                    ps[dir].luInv ? toggleCase(ci) : ci
                );
            }

            index += dir==0?1:-1;
            count++;
        }
        out.println(sb);
        out.flush();
    }

    private static char toggleCase(char c) {
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        } else {
            return Character.toLowerCase(c);
        }
    }

    private static class Memo {
        int dir;
        int index;
        public Memo(int dir, int index) {
            this.dir = dir;
            this.index = index;
        }
    }

    private static class P {
        char end;
        char rev;
        boolean luInv;
        public P(char end, char rev, boolean luInv) {
            this.end = end;
            this.rev = rev;
            this.luInv = luInv;
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(null, () -> solve(), "", 64L * 1024 * 1024);
        thread.setUncaughtExceptionHandler((t, e) -> {
            e.printStackTrace();
            System.exit(1);
        });
        thread.start();
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