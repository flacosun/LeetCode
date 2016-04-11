import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 * A classic DFS with additional dedupe check.
 * See also http://fisherlei.blogspot.com/2012/12/leetcode-permutations-ii.html
 */
public class PermutationsII {

    public class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> permutations = new ArrayList<>();
            if (nums.length == 0) {
                return permutations;
            }
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            dfs(nums, 0, visited, new LinkedList<>(), permutations);

            return permutations;
        }

        private void dfs(int[] nums, int step, boolean[] visited, List<Integer> permutation, List<List<Integer>> permutations) {
            if (step == nums.length) {
                permutations.add(new ArrayList<>(permutation));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                        continue;
                    }
                    visited[i] = true;
                    permutation.add(nums[i]);
                    dfs(nums, step + 1, visited, permutation, permutations);
                    permutation.remove(permutation.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
