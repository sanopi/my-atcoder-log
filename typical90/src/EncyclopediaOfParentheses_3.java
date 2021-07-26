import java.util.Scanner;

public class EncyclopediaOfParentheses_3 {

    static final String LEFT = "(";
    static final String RIGHT = ")";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n % 2 == 1) return;

        // bit全探索する
        // 1<<n = 2^n （00000...01を左にnビットずらす -> 1000...00）
        for (int i = 0; i < (1 << n); i++) {
            String s = "";
            for (int j = n-1; j >=0 ; j--) {
                // i の jビット目が0か判定
                // 1<<jは、jビット目が1でそれ以外が0の数。
                // & は、同じビットが両方とも1ならば1になるビットAND演算。
                // 000110011 （i）
                // 000100000 （1 << 6）
                // 000100000 （i & (1 << 6)） というイメージ。
                if ((i & (1 << j)) == 0) {
                    s += LEFT;
                } else {
                    s += RIGHT;
                }
            }
            if (isOk(s)) {
                System.out.println(s);
            }
        }
    }

    static boolean isOk(String s) {
        int dep = 0;
        for (int j = 0; j < s.length(); j++) {
            String substring = s.substring(j, j + 1);
            if (substring.equals(LEFT)) { dep += 1; }
            if (substring.equals(RIGHT)) { dep -= 1; }
            if (dep < 0) { return false; }
        }
        return dep == 0;
    }
}
