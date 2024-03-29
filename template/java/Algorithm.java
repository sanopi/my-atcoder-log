import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Algorithm {

    private static int lowerBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key <= a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }

    private static int upperBound(long[] a, long key) {
        int ok = a.length;
        int ng = -1;
        while (ok-ng > 1) {
            int mid = (ok+ng)/2;
            if (key < a[mid]) {
                ok = mid;
            } else {
                ng = mid;
            }
        }
        return ok;
    }

    private static List<Integer> topologicalSort(List<Integer>[] graph) {
        int[] inCount = new int[graph.length];
        for (List<Integer> nexts : graph) { for (Integer next : nexts) { inCount[next]++; } }
        // 必要に応じてPriorityQueueなどを使う
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) { if (inCount[i]==0) q.add(i); }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer node = q.poll();
            result.add(node);
            for (final Integer next : graph[node]) {
                inCount[next]--;
                if (inCount[next] == 0) { q.add(next); }
            }
        }
        return result;
    }

    private static int[] compress(int[] array) {
        TreeSet<Integer> sortedElements = Arrays.stream(array).boxed().collect(Collectors.toCollection(TreeSet::new));
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int element: sortedElements) map.put(element, count++);
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) res[i] = map.get(array[i]);
        return res;
    }
}
