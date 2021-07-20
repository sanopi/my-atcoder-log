import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// TODO WAになる...
public class ABC209D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        ArrayList<Pair> roads = new ArrayList<>(n);
        for (int i = 0; i < n-1; i++) {
            roads.add(new Pair(scanner.nextInt(), scanner.nextInt()));
        }
        roads.sort(Comparator.comparing(pair -> pair.a));

        int[] towns = new int[n+1];
        towns[1] = 1;
        for (int i = 0; i < n; i++) {
            for (Pair road : roads) {
                int a = road.a;
                int b = road.b;
                if (towns[a] == 1) {
                    towns[b] = 2;
                } else {
                    towns[b] = 1;
                }
                if (towns[b] == 1) {
                    towns[a] = 2;
                } else {
                    towns[a] = 1;
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if (towns[c] == towns[d]) {
                System.out.println("Town");
            } else {
                System.out.println("Road");
            }
        }
    }

    private static class Pair {
        int a;
        int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
