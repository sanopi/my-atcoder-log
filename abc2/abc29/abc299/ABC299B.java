import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC299B {

    public static void main(String[] args) {
        int n = nextInt();
        int t = nextInt();
        int[] c = nextIntArray(n);
        int[] r = nextIntArray(n);
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            cards[i] = new Card(c[i], r[i], i);
        }
        List<Card> tCards = Arrays.stream(cards).filter(card -> card.c == t).collect(Collectors.toList());
        if (tCards.size()>0) {
            Card ans = tCards.stream().max(Comparator.comparing(card -> card.r)).orElse(null);
            out.println(ans.i + 1);
        } else {
            Card ans = Arrays.stream(cards).filter(card -> card.c == c[0]).max(Comparator.comparing(card -> card.r)).orElse(null);
            out.println(ans.i + 1);
        }

        out.flush();
    }

    private static class Card {
        int c;
        int r;
        int i;
        public Card(int c, int r, int i) {
            this.c = c;
            this.r = r;
            this.i = i;
        }
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