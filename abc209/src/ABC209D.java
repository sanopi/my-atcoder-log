import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABC209D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // Graphを作る
        List<List<Integer>> g = new ArrayList<>(n+1) ;
        for (int i = 0; i < n+1; i++) g.add(new ArrayList<>());

        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            g.get(a).add(b);
            g.get(b).add(a);
        }

        // 深さの偶奇を計算
        int[] dep = new int[n+1];

        set(g, dep, 1, 1);

        // 偶奇の一致で出力分け
        for (int i = 0; i < q; i++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if (dep[c] == dep[d]) {
                System.out.println("Town");
            } else {
                System.out.println("Road");
            }
        }
    }

    private static void set(List<List<Integer>> graph, int[] dep, int key, int value) {
        dep[key] = value;
        List<Integer> integers = graph.get(key);
        integers.forEach(integer -> {
            if (dep[integer] == 0) {
                set(graph, dep, integer, (value - 3) * -1);
            }
        });
    }
}
