import java.io.PrintWriter;
import java.util.Scanner;

public class CodeFestival2017QualaC {

    public static void main(String[] args) {
        int h = nextInt();
        int w = nextInt();
        int[] counts = new int[26];
        for (int i = 0; i < h; i++) {
            char[] chars = next().toCharArray();
            for (int j = 0; j < w; j++) {
                counts[chars[j]-'a']++;
            }
        }
        int[] fourCounts = new int[4];
        for (int i = 0; i < 26; i++) {
            fourCounts[counts[i]%4]++;
        }


        if (h%2==1 && w%2==1) {
            out.println(fourCounts[2]*2+fourCounts[3]*2<=h+w-2 && fourCounts[1]+fourCounts[3] == 1 ? "Yes" : "No");
        } else if (h%2==1 && w%2==0) {
            out.println(fourCounts[2]*2<=w && fourCounts[1]+fourCounts[3] == 0?  "Yes" : "No");
        } else if (h%2==0 && w%2==1) {
            out.println(fourCounts[2]*2<=h && fourCounts[1]+fourCounts[3] == 0?  "Yes" : "No");
        } else {
            out.println(fourCounts[1]==0&&fourCounts[2]==0&&fourCounts[3]==0?"Yes":"No");
        }

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