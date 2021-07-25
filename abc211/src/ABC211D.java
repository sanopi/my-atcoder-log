import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class ABC211D {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        int m = scanner.nextInt();

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }

        int[] counts = new int[n];
        counts[0] = 1;
        int[] depth = new int[n];
        depth[0] = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (queue.peek() != null) {
            Integer current = queue.poll();
            for (Integer next : g[current]) {
                if (depth[next] == 0) {
                    depth[next] = depth[current] + 1;
                    counts[next] = counts[current];
                    queue.add(next);
                } else if (depth[next] == depth[current] + 1) {
                    counts[next] = (counts[next] + counts[current]) % 1000000007;
                }
            }
        }

        System.out.println(counts[n-1]);
    }
}
