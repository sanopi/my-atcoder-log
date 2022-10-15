import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ABC273E {

    public static void main(String[] args) {
        int q = nextInt();
        Map<Integer, Node> yNodeMap = new HashMap<>();
        Node current = null;
        while (q-- > 0) {
            String op = next();
            if (op.equals("ADD")) {
                int x = nextInt();
                Node newNode = new Node(current, x);
                current = newNode;
            } else if (op.equals("DELETE")) {
                Node newNode = Optional.ofNullable(current).map(n -> n.prev).orElse(null);
                current = newNode;
            } else if (op.equals("SAVE")) {
                int y = nextInt();
                yNodeMap.put(y, current);
            } else if (op.equals("LOAD")) {
                int z = nextInt();
                current = yNodeMap.get(z);
            }
            out.print((current==null?-1:current.num) + " ");
        }
        out.println();
        out.flush();
    }

    private static class Node {
        final Node prev;
        final int num;
        private Node(Node prev, int num) {
            this.prev = prev;
            this.num = num;
        }
        @Override
        public String toString() {
            return "Node{" +
                "prev=" + prev +
                ", num=" + num +
                '}';
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