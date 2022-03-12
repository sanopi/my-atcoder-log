import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ABC243E {

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int a = nextInt()-1;
            int b = nextInt()-1;
            int c = nextInt();
            edges[i] = new Edge(a, b, c);
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE/2);
        }

        for (int i = 0; i < m; i++) {
            Edge edge = edges[i];
            int a = edge.a;
            int b = edge.b;
            cost[a][b] = edge.c;
            cost[b][a] = edge.c;
        }

        boolean[][] mawari = new boolean[n][n];

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (cost[i][j] == cost[i][k] + cost[k][j]) {
                        mawari[i][j] = true;
                    }
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }


        int count = 0;
        for (Edge edge : edges) {
            if (cost[edge.a][edge.b] < edge.c || (cost[edge.a][edge.b] == edge.c && mawari[edge.a][edge.b])) {
                count++;
            }
        }

        out.println(count);
        out.flush();
    }

    private static class Edge {
        int a;
        int b;
        int c;
        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
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