import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ABC166F {

    private static void solve() {
        int n = nextInt();
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int[] abc = {a, b, c};
        List<Character> ans = new ArrayList<>();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = next();
        }
        for (int i = 0; i < n; i++) {
            String s = ss[i];
            int first = s.charAt(0) - 'A';
            int second = s.charAt(1) - 'A';
            int other = IntStream.range(0, 3).filter(ii -> ii!=first && ii!=second).findFirst().getAsInt();
            if (i < n-1 && abc[first] == 1 && abc[second] == 1 && abc[other] == 0) {
                String s1 = ss[i+1];
                int first1 = s1.charAt(0) - 'A';
                int second1 = s1.charAt(1) - 'A';
                if (first1 == other) {
                    if (second1 == first) {
                        abc[first]++;
                        abc[second]--;
                        ans.add((char)(first+'A'));
                    } else {
                        abc[first]--;
                        abc[second]++;
                        ans.add((char)(second+'A'));
                    }
                    continue;
                } else if (second1 == other) {
                    if (first1 == first) {
                        abc[first]++;
                        abc[second]--;
                        ans.add((char)(first+'A'));
                    } else {
                        abc[first]--;
                        abc[second]++;
                        ans.add((char)(second+'A'));
                    }
                    continue;
                }
            }
            if (abc[first] == 0 && abc[second] == 0) {
                System.out.println("No");
                return;
            }
            if (abc[first] < abc[second]) {
                abc[first]++;
                abc[second]--;
                ans.add((char)(first+'A'));
            } else {
                abc[first]--;
                abc[second]++;
                ans.add((char)(second+'A'));
            }
        }
        out.println("Yes");
        ans.forEach(out::println);
        out.flush();
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