import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ABC208C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long k = scanner.nextLong();

        Map<Integer, Integer> map = new HashMap<>(n);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] b = Arrays.copyOf(a, n);
        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            map.put(b[i], i + 1);
        }

        long base = k / n;
        long rest = k % n;
        for (int i = 0; i < n; i++) {
            int addition = map.get(a[i]) - rest <= 0 ? 1 : 0;
            System.out.println(base + addition);
        }
    }
}
