import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Q26_IndependentSetOnATree_4 {

    static ArrayList<Integer>[] g;
    static int[] parts;
    static int count1 = 0;
    static int count2 = 0;

    public static void main(String[] args) {
        int n = nextInt();
        parts = new int[n];
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) { g[i] = new ArrayList<>(); }
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt() - 1;
            int b = nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        search(0, 1);
        int part = count1 >= (n / 2) ? 1 : 2;
        int outCount = 0;
        for (int i = 0; i < n; i++) {
            if (parts[i] == part) {
                out.print((i+1)+ " ");
                outCount+=1;
            }
            if (outCount == n/2) {
                break;
            }
        }
        out.flush();
    }

    private static void search(int node, int color) { // 1 or 2
        parts[node] = color;
        if (color == 1) {
            count1 += 1;
        } else {
            count2 += 1;
        }
        for (Integer next : g[node]) {
            if (parts[next] != 0) {
                continue;
            }
            search(next, (3 - color));
        }
    }


    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() {
        return scanner.next();
    }
    static int nextInt() {
        return Integer.parseInt(next());
    }
    static long nextLong() {
        return Long.parseLong(next());
    }
    static double nextDouble() {
        return Double.parseDouble(next());
    }
}