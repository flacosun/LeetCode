import java.util.*;

/**
 * 310. Minimum Height Trees
 * https://leetcode.com/submissions/detail/58920002/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/13/2016.
 */
public class MinimumHeightTrees {

    public class Solution {

        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            if (n == 1) {
                return Collections.singletonList(0);
            }

            List<Set<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            List<Integer> leaves = new ArrayList<>();

            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i).size() == 1) {
                    leaves.add(i);
                }
            }

            while (n > 2) {
                n -= leaves.size();
                List<Integer> newLeaves = new ArrayList<>();

                for (int i : leaves) {
                    int j = adj.get(i).iterator().next();
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) {
                        newLeaves.add(j);
                    }
                }

                leaves = newLeaves;
            }

            return leaves;
        }
    }
}
