import java.util.LinkedList;
import java.util.List;

/**
 * 227. Basic Calculator II My Submissions QuestionEditorial Solution
 * https://leetcode.com/problems/basic-calculator-ii/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/14/2016.
 */
public class BasicCalculatorII {

    public class Solution {

        public int calculate(String s) {
            List<Integer> nums = new LinkedList<>();
            List<Character> ops = new LinkedList<>();
            for (int i = 0; i < s.length();) {
                char c = s.charAt(i);
                if (c == ' ') {
                    i++;
                    continue;
                }
                int len = 1;
                // If it's operator, push to ops queue;
                if ("+-*/".indexOf(c) >= 0) {
                    ops.add(c);
                } else {
                    // Parse next integer
                    while (i + len < s.length() && s.charAt(i + len) >= '0' && s.charAt(i + len) <= '9') {
                        len++;
                    }
                    int n = Integer.parseInt(s.substring(i, i + len));
                    // If operation is +/-, skip for now
                    if (ops.isEmpty() || ops.get(ops.size() - 1) == '+' || ops.get(ops.size() - 1) == '-') {
                        nums.add(n);
                    } else {
                        // Compute * or /
                        char o = ops.remove(ops.size() - 1);
                        int p = nums.remove(nums.size() - 1);
                        nums.add(o == '*' ? p * n : p / n);
                    }
                }
                i += len;
            }

            if (nums.isEmpty()) {
                return 0;
            }

            // Compute +/-
            int result = nums.remove(0);
            while (!ops.isEmpty()) {
                char o = ops.remove(0);
                int i = nums.remove(0);
                result = o == '+' ? i + result : result - i;
            }

            return result;
        }
    }
}
