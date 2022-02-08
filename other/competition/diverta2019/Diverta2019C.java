import java.io.PrintWriter;
import java.util.Scanner;

public class Diverta2019C {

    public static void main(String[] args) {
        int n = nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = next();
        }
        int baseCount = 0;
        int lastACount = 0;
        int firstBCount = 0;
        int baCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s[i].length()-1; j++) {
                if (s[i].charAt(j)=='A'&&s[i].charAt(j+1)=='B') {
                    baseCount++;
                }
            }
            if (s[i].endsWith("A") && !s[i].startsWith("B")) {
                lastACount++;
            }
            if (s[i].startsWith("B") && !s[i].endsWith("A")) {
                firstBCount++;
            }
            if (s[i].endsWith("A") && s[i].startsWith("B")) {
                baCount++;
            }
        }



        int ans = 0;
        if (baCount>0) {
            int first = Math.min(lastACount, 1);
            int middle = baCount;
            int last = Math.min(firstBCount, 1);
            ans+=(first+middle+last-1);

            lastACount-=first;
            firstBCount-=last;
        }
        ans+=Math.min(lastACount, firstBCount);
        out.println(baseCount+ans);
        out.flush();
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