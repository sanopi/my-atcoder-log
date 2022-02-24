import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ABC114C {

    public static void main(String[] args) {
        int n = nextInt();
        long ans = 0;
//        ans = solve1(n);
//        ans = solve2(n);
        ans = solve3(n);
        out.println(ans);
        out.flush();
    }

    private static long solve3(int n) {
        return rec(0L, n).count();
    }

    private static Stream<Long> rec(Long num, int n) {
        if (num > n) {
            return Stream.of();
        }
        List<Long> nexts = List.of(3, 5, 7).stream()
            .map(last -> num * 10 + last)
            .collect(Collectors.toList());
        return Stream.concat(
            nexts.stream().filter(next -> next<=n).filter(next -> isValid(next)),
            nexts.stream().flatMap(next -> rec(next, n))
        );
    }

    private static int solve2(int n) {
        int ans = 0;
        int num = 0;
        String s = "0";
        while (Long.parseLong(s) <= n) {
            if (isValid(s) && !s.contains("0")) {
                ans++;
            }
            num++;
            s = Integer.toString(num, 4)
                .replaceAll("3", "7")
                .replaceAll("2", "5")
                .replaceAll("1", "3");

        }
        return ans;
    }

    private static int solve1(int n) {
        int ans = 0;
        String num = "333";
        while (Long.parseLong(num) <= n) {
            if (isValid(num)) {
                ans++;
            }
            num = next(num);
        }
        return ans;
    }

    private static String next(String current) {
        if (current.equals("7".repeat(current.length()))) {
            return "3".repeat(current.length()+1);
        }
        char[] chars = current.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '3') {
                chars[i] = '5';
                break;
            }
            if (chars[i] == '5') {
                chars[i] = '7';
                break;
            }
            chars[i] = '3';
        }
        return String.valueOf(chars);
    }

    private static boolean isValid(Long l) {
        return isValid(Long.toString(l));
    }
    private static boolean isValid(String s) {
        boolean three = false;
        boolean five = false;
        boolean seven = false;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '3': three=true;continue;
                case '5': five=true;continue;
                case '7': seven=true;continue;
            }
        }
        return three && five && seven;
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() { return Integer.parseInt(next()); }
    static long nextLong() { return Long.parseLong(next()); }
    static double nextDouble() { return Double.parseDouble(next()); }
    static int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) { array[i] = nextInt(); }
        return array;
    }
    static long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) { array[i] = nextLong(); }
        return array;
    }

}