import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ABC259F {

    private static List<Edge>[] tree;
    private static int[] d;
    private static long[] memo;
    private static int n;
    private static FastScanner fs;

    public static void main(String[] args) {
        fs = new FastScanner();
        n = (int) fs.nextLong();
        d = nextIntArray(n);
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = (int)fs.nextLong()-1;
            int v = (int)fs.nextLong()-1;
            int w = (int)fs.nextLong();
            tree[u].add(new Edge(u, v, w));
            tree[v].add(new Edge(v, u, w));
        }
        memo = new long[n *2];
        long ans = dfs(0, -1, false);
        System.out.println(ans);
    }

    private static long dfs(int current, int prev, boolean minus) {
        if (memo[current+ (minus?n:0)] > 0) {
            return memo[current+ (minus?n:0)];
        }
        List<Result> results = new ArrayList<>();
        for (Edge edge : tree[current]) {
            if (edge.to == prev) continue;
            results.add(new Result(
                (d[edge.to] > 0 && edge.w > 0) ? (dfs(edge.to, current, true) + edge.w) : 0,
                dfs(edge.to, current, false)
            ));
        }
        results.sort(Comparator.comparing((Result r) -> -(r.pos-r.neg)));
        int cd = d[current] + (minus ? -1 : 0);
        long res = 0;
        int index = 0;
        while (index < results.size() && cd > 0) {
            Result r = results.get(index);
            if (r.pos > r.neg) {
                res += r.pos;
                cd--;
                index++;
            } else {
                break;
            }
        }
        for (int i = index; i < results.size(); i++) {
            res += results.get(i).neg;
        }

        return memo[current+ (minus?n:0)] = res;
    }

    private static class Result {
        long pos;
        long neg;
        public Result(long pos, long neg) {
            this.pos = pos;
            this.neg = neg;
        }
    }

    private static class Edge {
        int from;
        int to;
        int w;
        public Edge(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = (int)fs.nextLong(); }
        return array;
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        private void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
        public boolean hasNext() { skipUnprintable(); return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
    }
}