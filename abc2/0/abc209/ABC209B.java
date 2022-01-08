import java.util.Scanner;

public class ABC209B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }

        System.out.println(x - (sum - (n / 2)) >= 0 ? "Yes" : "No");

    }
}
