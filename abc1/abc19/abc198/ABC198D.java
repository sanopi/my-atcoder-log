import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ABC198D {

    private static long[] ans = new long[3];
    private static String s1;
    private static String s2;
    private static String s3;
    private static Set<Character> chars = new HashSet<>();
    private static int[] charNum = new int[26];
    private static char[] numChar = new char[10];


    public static void main(String[] args) {
        s1 = next();
        s2 = next();
        s3 = next();

        for (char c: s1.toCharArray()) chars.add(c);
        for (char c: s2.toCharArray()) chars.add(c);
        for (char c: s3.toCharArray()) chars.add(c);
        if (chars.size() > 10) {
            System.out.println("UNSOLVABLE");
            return;
        }

        Arrays.fill(numChar, ' ');
        Arrays.fill(charNum, -1);
        solve(new ArrayList<>(chars), 0);
        for (long a : ans) {
            if (a == 0) {
                System.out.println("UNSOLVABLE");
                return;
            }
        }
        for (long a :ans){
            out.println(a);
        }
        out.flush();
    }

    private static void solve(List<Character> charList, int index) {
        if (index == charList.size()) {
            String[] s = {s1, s2, s3};
            List<Long> longs = Arrays.stream(s).map(st -> convert(st)).collect(Collectors.toList());
            if (longs.get(0) + longs.get(1) != longs.get(2)) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                if (longs.get(i) == 0 || longs.get(i).toString().length() != s[i].length()) {
                    return;
                }
            }
            for (int i = 0; i < 3; i++) {
                ans[i] = longs.get(i);
            }
            return;
        }
        Character c = charList.get(index);
        for (int j = 0; j < 10; j++) {
            if (numChar[j] != ' ') {
                continue;
            }
            charNum[c-'a'] = j;
            numChar[j] = c;
            solve(charList, index+1);
            charNum[c-'a'] = -1;
            numChar[j] = ' ';
        }
    }

    private static long convert(String s) {
        long res = 0;
        for (char c : s.toCharArray()) {
            res *= 10;
            res += charNum[c-'a'];
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