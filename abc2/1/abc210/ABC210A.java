import java.util.Scanner;

public class ABC210A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(Math.min(n, a) * x + Math.max(n - a, 0) * y);
    }
}