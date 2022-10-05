import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC271C {

    public static void main(String[] args) {
        int n = nextInt();
        int[] a = new int[n];
        Set<Integer> have = new HashSet<>();
        int additional = 0;
        for (int i = 0; i < n; i++) {
            a[i] = nextInt()-1;
            if (have.contains(a[i])) {
                additional++;
            }
            have.add(a[i]);
        }
        Arrays.sort(a);
        Deque<Integer> q = new ArrayDeque<>();
        have.stream().sorted().forEach(q::add);

        int ans = 0;
        while (!q.isEmpty()) {
            Integer first = q.peekFirst();
            if (ans == first) {
                ans++;
                q.pollFirst();
                continue;
            }
            int count = 0;
            for (int i = 0; i < 2; i++) {
                if (additional>0) {
                    additional--;
                    count++;
                } else {
                    if (q.isEmpty()) {
                        break;
                    }
                    q.pollLast();
                    count++;
                }
            }
            if (count==2) {
                ans++;
            }
        }
        out.println(ans+additional/2);
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