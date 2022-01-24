import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ABC211B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> s = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            s.add(scanner.next());
        }

        System.out.println(s.contains("H") && s.contains("2B") && s.contains("3B") && s.contains("HR") ? "Yes" : "No");
    }
}
