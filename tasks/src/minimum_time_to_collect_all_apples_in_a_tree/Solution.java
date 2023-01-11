package minimum_time_to_collect_all_apples_in_a_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node,
                   int parent,
                   Map<Integer, List<Integer>> adj,
                   List<Boolean> hasApple) {
        if (!adj.containsKey(node))
            return 0;

        int totalTime = 0;
        int childTime;
        for (int child : adj.get(node)) {
            if (child == parent)
                continue;
            childTime = dfs(child, node, adj, hasApple);
            // childTime > 0 indicates subtree of child has apples. Since the root node of the
            // subtree does not contribute to the time, even if it has an apple, we have to check it
            // independently.
            if (childTime > 0 || hasApple.get(child))
                totalTime += childTime + 2;
        }
        return totalTime;
    }
}
