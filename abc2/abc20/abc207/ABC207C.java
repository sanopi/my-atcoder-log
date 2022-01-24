import java.util.Scanner;

public class ABC207C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long ans = 0;

        Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            Range newRange = new Range(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            for (int j = 0; j < i; j++) {
                if (ranges[j].hasCommon(newRange)) {
                    ans += 1;
                }
            }
            ranges[i] = newRange;
        }
        System.out.println(ans);
    }

    static class Range {
        int type;
        int start;
        int end;

        Range(int type, int start, int end) {
            this.type = type;
            this.start = start;
            this.end = end;
        }

        boolean hasCommon(Range other) {
            if (this.start == other.start) {
                return true;
            }
            if (this.start < other.start) {
                if (other.start < this.end) {
                    return true;
                }
                if (this.end < other.start) {
                    return false;
                }

                if (this.end == other.start) {
                    return (this.type == 1 || this.type == 3) && (other.type == 1 || other.type == 2);
                }
            }
            // other.start < this.start
            return other.hasCommon(this);
        }
    }
}
