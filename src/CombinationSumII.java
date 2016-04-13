import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/12/2016.
 * Typical backtracking problem.
 */
public class CombinationSumII {

    public class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            if (candidates.length == 0) {
                return result;
            }
            Arrays.sort(candidates);
            boolean[] visited = new boolean[candidates.length];
            dfs(candidates, 0, 0, target, visited, new LinkedList<>(), result);

            return result;
        }

        private void dfs(int[] candidates, int start, int sum, int target, boolean[] visited,
                         List<Integer> solution, List<List<Integer>> result) {
            if (sum > target) {
                return;
            }

            if (sum == target) {
                result.add(new ArrayList<>(solution));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > 0 && candidates[i - 1] == candidates[i] && !visited[i - 1]) {
                    continue;
                }
                sum += candidates[i];
                solution.add(candidates[i]);
                visited[i] = true;
                dfs(candidates, i + 1, sum, target, visited, solution, result);
                visited[i] = false;
                solution.remove(solution.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
