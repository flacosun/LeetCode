package patching_array;

/**
 * https://leetcode.com/problems/patching-array/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int miss = 1;
        int count = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                count++;
                // Break before (miss << 1) > Integer.MAX_VALUE to prevent from an infinite loop.
                if (miss > (Integer.MAX_VALUE >> 1)) {
                    break;
                }
                miss <<= 1;
            }
        }

        return count;
    }
}

