package find_if_path_exists_in_graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        IntStream.range(0, n).forEach(u -> g.put(u, new ArrayList<>()));
        for (int[] e : edges) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (q.add(source), seen.add(source); !q.isEmpty();)
            if (q.peek() == destination) {
                return true;
            } else {
                g.get(q.poll()).stream().filter(seen::add).forEach(q::offer);
            }

        return false;
    }
}
