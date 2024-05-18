import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC354C {

    private static void solve() {
        int n = nextInt();
        Card[] cards = new Card[n];
        for (int i = 0; i < n; i++) {
            int a = nextInt();
            int c = nextInt();
            cards[i] = new Card(a, c, i);
        }

        Map<Integer, List<Card>> map = Arrays.stream(cards).collect(Collectors.groupingBy(card -> card.c));
        List<CCards> cCardsList = new ArrayList<>();
        map.forEach((cost, cardList) -> cCardsList.add(new CCards(cost, cardList)));
        cCardsList.sort(Comparator.comparing(cCards->cCards.c));
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for (CCards cCards : cCardsList) {
            int tmp = 0;
            for (Card card : cCards.cardList) {
                if (max <= card.a) {
                    ans.add(card.i);
                }
                tmp = Math.max(tmp, card.a);
            }
            max = Math.max(max, tmp);
        }
        out.println(ans.size());
        ans.stream().sorted().forEach(i -> out.print((i+1)+" "));

        out.flush();
    }

    private static class CCards {
        int c;
        List<Card> cardList;
        public CCards(int c, List<Card> cardList) {
            this.c = c;
            this.cardList = cardList;
        }
    }

    private static class Card {
        int a;
        int c;
        int i;
        public Card(int a, int c, int i) {
            this.a = a;
            this.c = c;
            this.i = i;
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