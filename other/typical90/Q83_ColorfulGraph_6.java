import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Q83_ColorfulGraph_6 {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            g[a].add(b);
            g[b].add(a);
        }
        int q = nextInt();
        Query[] queries = new Query[q];
        int[] qx = new int[q];
        int[] qy = new int[q];
        for (int i = 0; i < q; i++) {
            int x = nextInt()-1;
            int y = nextInt();
            queries[i] = new Query(x, y);
            qx[i] = x;
            qy[i] = y;
        }
        solve1(n, m, g, q, qx, qy);
//        solve2(n, m, g, q, queries);
        out.flush();
    }

    // クエリ平方分割
    private static void solve1(int n, int m, List<Integer>[] g, int q, int[] qx, int[] qy) {
        int[] colors = new int[n];
        Arrays.fill(colors, 1);
        int rootQ = 600;
        boolean[] appeared = new boolean[n];
        List<Integer>[] newG = new List[n];
        int[] lastQueriedIndex = new int[n];
        for (int i = 0; i < n; i++) {
            newG[i] = new ArrayList<>();
        }
        for (int i = 0; i < q; i++) {
            int max = Math.min(q, i + rootQ);
            int count = max - i;
            Arrays.fill(appeared, false);
            for (int j = 0; j < count; j++) {
                appeared[qx[i+j]] = true;
            }
            for (int j = 0; j < n; j++) {
                newG[j].clear();
                if (!appeared[j]) continue;
                for (int next : g[j]) {
                    if (!appeared[next]) continue;
                    newG[j].add(next);
                }
            }

            Arrays.fill(lastQueriedIndex, -1);
            for (int j = 0; j < count; j++) {
                int x = qx[i+j];
                int y = qy[i+j];
                out.println(colors[x]);
                colors[x] = y;
                for (int next : newG[x]) {
                    colors[next] = y;
                }
                lastQueriedIndex[x] = i+j;
            }

            for (int j = 0; j < n; j++) {
                int index = lastQueriedIndex[j];
                for (int next : g[j]) {
                    index = Math.max(index, lastQueriedIndex[next]);
                }
                if (index != -1) {
                    colors[j] = qy[index];
                }
            }

            i += count-1;
        }
    }

    // 出次数で平方分割？
    private static void solve2(int n, int m, List<Integer>[] g, int q, Query[] queries) {

    }

    private static class Query {
        int x;
        int y;
        public Query(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static FastScanner fs = new FastScanner();
    static String next() { return fs.next(); }
    static int nextInt() {
        return fs.nextInt();
    }
    static long nextLong() {
        return fs.nextInt();
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

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
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