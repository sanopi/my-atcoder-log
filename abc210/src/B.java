import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        String s = scanner.next();
        int badIndex = s.indexOf("1") + 1;
        if (badIndex % 2 == 1) {
            System.out.println("Takahashi");
        } else {
            System.out.println("Aoki");
        }
    }
}
