import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Algorithm {

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
}
