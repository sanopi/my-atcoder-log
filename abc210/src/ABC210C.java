import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ABC210C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        List<Integer> colors = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());


        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer color : colors.subList(0, k)) {
            Integer rightCount = map.getOrDefault(color, 0);
            map.put(color, rightCount + 1);
        }

        int max = map.size();

        for (int i = 1; i < n - k + 1; i++) {
            Integer right = colors.get(i + k - 1);
            Integer rightCount = map.getOrDefault(right, 0);
            map.put(right, rightCount + 1);

            Integer left = colors.get(i - 1);
            Integer leftCount = map.get(left);
            if (leftCount <= 1) {
                map.remove(left);
            } else {
                map.put(left, leftCount - 1);
            }

            int size = map.size();
            if (size > max) {
                max = size;
            }
        }
        System.out.println(max);
    }
}
