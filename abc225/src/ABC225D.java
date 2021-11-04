import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ABC225D {

    public static void main(String[] args) {
        int n = nextInt();
        int q = nextInt();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(null, null);
        }

        for (int i = 0; i < q; i++) {
            int t = nextInt();
            int x = nextInt()-1;
            if (t == 1) {
                int y = nextInt()-1;
                nodes[x].next = y;
                nodes[y].prev = x;
            } else if (t == 2) {
                int y = nextInt()-1;
                nodes[x].next = null;
                nodes[y].prev = null;
            } else {
                Deque<Integer> deque = new ArrayDeque<>();
                deque.add(x);
                Integer p = nodes[x].prev;
                while (p != null) {
                    deque.addFirst(p);
                    p = nodes[p].prev;
                }
                p = nodes[x].next;
                while (p != null) {
                    deque.addLast(p);
                    p = nodes[p].next;
                }
                out.print(deque.size());
                for (final Integer integer : deque) {
                    out.print(" " + (integer+1));
                }
                out.println();
            }
        }

        out.flush();
    }

    private static class Node {
        Integer prev;
        Integer next;
        public Node(final Integer prev, final Integer next) {
            this.prev = prev;
            this.next = next;
        }
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