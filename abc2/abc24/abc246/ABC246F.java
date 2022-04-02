import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ABC246F {

    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int n = nextInt();
        int l = nextInt();
        String[] keys = new String[n];
        for (int i = 0; i < n; i++) {
            keys[i] = next();
        }
        List<Character>[] keysList = new List[n];
        for (int i = 0; i < n; i++) {
            keysList[i] = new ArrayList<>();
            for (char c : keys[i].toCharArray()) {
                keysList[i].add(c);
            }
        }

        long ans = 0;
        for (int i = 1; i < 1 << n; i++) {
            List<Integer> keyBoards = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1<<j)) !=0) {
                    keyBoards.add(j);
                }
            }
            Set<Character> charSet = new HashSet<>();
            for (int j = 0; j < 26; j++) {
                charSet.add((char)(j+'a'));
            }
            for (Integer keyBoard : keyBoards) {
                Set<Character> newSet = new HashSet<>();
                for (Character key : keysList[keyBoard]) {
                    if (charSet.contains(key)) newSet.add(key);
                }
                charSet = newSet;
            }
            if (Integer.bitCount(i)%2==1) {
                ans += modPow(charSet.size(), l, MOD);
            } else {
                ans -= modPow(charSet.size(), l, MOD);
            }
            ans%=MOD;
        }
        out.println((ans+MOD)%MOD);
        out.flush();
    }

    private static long modPow(long a, long n, int mod) {
        long x = a % mod;
        if (x == 0) {
            return x;
        }
        long res = 1;
        int i = 0;
        while (true) {
            long exp = 1L << i;
            if (exp > n) {
                break;
            }
            if ((n & exp) != 0) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            i += 1;
        }

        return res;
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