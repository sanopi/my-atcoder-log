import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC344E {

    private static void solve() {
        int n = nextInt();
        int[] a = nextIntArray(n);
        Map<Integer, Node> nodeMap = new HashMap();
        nodeMap.put(a[0], new Node(null, null));
        for (int i = 1; i < n; i++) {
            Node prevNode = nodeMap.get(a[i - 1]);
            prevNode.next = a[i];
            nodeMap.put(a[i], new Node(a[i-1], null));
        }
        int start = a[0];

        int q = nextInt();
        while (q-->0) {
            int t = nextInt();
            if (t == 1) {
                int x = nextInt();
                int y = nextInt();
                Node currentNode = nodeMap.get(x);
                if (currentNode.next != null) {
                    Node nextNode = nodeMap.get(currentNode.next);
                    nodeMap.put(y, new Node(x, currentNode.next));
                    nextNode.prev = y;
                    currentNode.next = y;
                } else {
                    currentNode.next = y;
                    nodeMap.put(y, new Node(x, null));
                }
            } else {
                int x = nextInt();
                Node currentNode = nodeMap.get(x);
                if (currentNode.prev != null) {
                    nodeMap.get(currentNode.prev).next = currentNode.next;
                }
                if (currentNode.next != null) {
                    nodeMap.get(currentNode.next).prev = currentNode.prev;
                }

                if (start == x) {
                    start = currentNode.next;
                }
                nodeMap.remove(x);
            }
        }
        Integer ans = start;
        while (ans != null) {
            out.print(ans + " ");
            ans = nodeMap.get(ans).next;
        }
        out.println();
        out.flush();
    }

    private static class Node {
        Integer prev;
        Integer next;
        public Node(Integer prev, Integer next) {
            this.prev = prev;
            this.next = next;
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