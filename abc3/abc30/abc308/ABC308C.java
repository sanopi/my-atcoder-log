import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ABC308C {

    public static void main(String[] args) {
        int n = nextInt();
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person(i+1, nextInt(), nextInt());
        }
        Arrays.sort(people, Comparator.reverseOrder());
        for (Person person : people) {
            out.print(person.i + " ");
        }
        out.println();
        out.flush();
    }

    private static class Person implements Comparable<Person> {
        int i;
        long a;
        long b;
        public Person(int i, long a, long b) {
            this.i = i;
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Person o) {
            long me = this.a*(o.a+o.b);
            long other = o.a*(this.a+this.b);
            return Long.compare(me, other);
        }
    }

    static PrintWriter out = new PrintWriter(System.out);
    static Scanner scanner = new Scanner(System.in);
    static String next() { return scanner.next(); }
    static int nextInt() {
        int res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
    static long nextLong() {
        long res = 0;
        char[] chars = next().toCharArray();
        boolean minus = chars[0] == '-';
        int start = minus?1:0;
        for (int i = start; i < chars.length; i++) {
            res = res*10 + (chars[i]-'0');
        }
        return minus?-res:res;
    }
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