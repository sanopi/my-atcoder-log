import java.util.Scanner;

public class ABC211C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] s = scanner.next().split("");
        int mod = 1000000007;

        int n = s.length;
        int[] c = new int[n];
        int[] ch = new int[n];
        int[] cho = new int[n];
        int[] chok = new int[n];
        int[] choku = new int[n];
        int[] chokud = new int[n];
        int[] chokuda = new int[n];
        int[] chokudai = new int[n];

        if (s[0].equals("c")) {
            c[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            String letter = s[i];
            c[i] = c[i-1];
            ch[i] = ch[i-1];
            cho[i] = cho[i-1];
            chok[i] = chok[i-1];
            choku[i] = choku[i-1];
            chokud[i] = chokud[i-1];
            chokuda[i] = chokuda[i-1];
            chokudai[i] = chokudai[i-1];

            if (letter.equals("c")){
                c[i] = (c[i-1] + 1) % mod;
            } else if (letter.equals("h")) {
                ch[i] = (ch[i-1] + c[i-1]) % mod;
            } else if (letter.equals("o")) {
                cho[i] = (cho[i-1] + ch[i-1]) % mod;
            } else if (letter.equals("k")) {
                chok[i] = (chok[i-1] + cho[i-1]) % mod;
            } else if (letter.equals("u")) {
                choku[i] = (choku[i-1] + chok[i-1]) % mod;
            } else if (letter.equals("d")) {
                chokud[i] = (chokud[i-1] + choku[i-1]) % mod;
            } else if (letter.equals("a")) {
                chokuda[i] = (chokuda[i-1] + chokud[i-1]) % mod;
            } else if (letter.equals("i")) {
                chokudai[i] = (chokudai[i-1] + chokuda[i-1]) % mod;
            }
        }
        System.out.println(chokudai[n-1]);
    }
}
