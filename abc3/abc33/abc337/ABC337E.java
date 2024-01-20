import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC337E {

    private static void solve() {
        int n = nextInt();

        if (n == 2) {
            System.out.println(1);
            System.out.println("1 1");
            String s = next();
            if (s.equals("1")) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }

            return;
        }


        List<Integer>[] persons = new List[10];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (((1 << j) & i) != 0) {
                    if (persons[j] == null) persons[j] = new ArrayList<>();
                    persons[j].add(i);
                }
            }
        }
        int m = 0;
        for (int i = 0; i < 10; i++) {
            if (persons[i] == null || persons[i].size() == 1) break;
            m++;
        }
        System.out.println(m);
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(persons[i].size()).append(" ");
            for (Integer person : persons[i]) {
                sb.append(person).append(" ");
            }
            System.out.println(sb);
        }
        String s = next();
        int ans = Integer.parseInt(new StringBuilder().append(s).reverse().toString(), 2);
        if (ans == 0) {
            System.out.println(1<<m);
        } else {
            System.out.println(ans);
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