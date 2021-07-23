import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

// Note 45度の回転を考慮できず敗北
public class ABC207D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Pair[] s = new Pair[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            Pair base = s[0];
            s[i] = s[i].minus(base);
        }
        HashSet<Pair> ss = new HashSet<>(Arrays.asList(s));


        Pair[] t = new Pair[n];
        for (int i = 0; i < n; i++) {
            t[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }

        for (int i = 0; i < n; i++) {
            Set<Pair> tSet = new HashSet<>(n);
            for (int j = 0; j < n; j++) {
                tSet.add(t[j].minus(t[i]));
            }

            if (ss.containsAll(tSet)) {
                System.out.println("Yes");
                return;
            }
            Set<Pair> tSet90 = tSet.stream().map(Pair::rotate90).collect(Collectors.toSet());
            if (ss.containsAll(tSet90)) {
                System.out.println("Yes");
                return;
            }
            Set<Pair> tSet180 = tSet.stream().map(Pair::rotate180).collect(Collectors.toSet());
            if (ss.containsAll(tSet180)) {
                System.out.println("Yes");
                return;
            }
            Set<Pair> tSet270 = tSet.stream().map(Pair::rotate270).collect(Collectors.toSet());
            if (ss.containsAll(tSet270)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Pair minus(Pair other) {
            return new Pair(this.x - other.x, this.y - other.y);
        }

        Pair rotate90() {
            return new Pair(-this.y, this.x);
        }

        Pair rotate180() {
            return new Pair(-this.x, this.y);
        }

        Pair rotate270() {
            return new Pair(this.y, -this.x);
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof Pair
                && this.x == ((Pair) obj).x
                && this.y == ((Pair) obj).y;
        }

        @Override
        public int hashCode() {
            return 2000 * x + y;
        }
    }
}