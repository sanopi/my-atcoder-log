import java.util.ArrayList;
import java.util.Scanner;

public class Q03_LongestCircularRoad_4 {

    static ArrayList<Integer>[] g;
    static int maxTown = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) { g[i] = new ArrayList<>(); }
        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        int[] d1 = new int[n];
        d1[0] = 1;
        bfs(d1, 0);

        int[] d2 = new int[n];
        d2[maxTown] = 1;
        bfs(d2, maxTown);

        System.out.println(d2[maxTown]);
    }

    static void bfs(int[] d, int town) {
        ArrayList<Integer> nexts = g[town];
        for (Integer next : nexts) {
            if (d[next] == 0) {
                d[next] = d[town] + 1;
                bfs(d, next);
            }
        }
        if (d[town] > d[maxTown]) {
            maxTown = town;
        }
    }
}
