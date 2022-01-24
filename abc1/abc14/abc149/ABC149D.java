import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

public class ABC149D {

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int r = nextInt();
        int s = nextInt();
        int p = nextInt();
        String t = next();

        long ans = 0;
        char[] done = new char[n];
        Map<Character, Integer> points = Map.of(
            'r', r,
            'p', p,
            's', s
        );
        Map<Character, Character> hands = Map.of(
            'r', 'p',
            'p', 's',
            's', 'r'
        );
        for (int i = 0; i < n; i++) {
            Character hand = hands.get(t.charAt(i));
            if (i-k>=0 && done[i-k]==hand) {
                continue;
            }
            done[i]=hand;
            ans += points.get(hand);
        }
        out.println(ans);
        out.flush();
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
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