import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ABC207A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        System.out.println(a[1] + a[2]);
    }
}
