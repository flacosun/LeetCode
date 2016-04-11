/**
 * 307. Range Sum Query - Mutable
 * https://leetcode.com/problems/range-sum-query-mutable/
 * <p>
 * The most obvious solution is to use brute force to calculate range sum.
 * A better solution is using a segment tree.
 * http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 */
public class RangeSumQuery {

    public class NumArray {

        private TreeNode root;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                root = constructTree(nums, 0, nums.length - 1);
            }
        }

        private TreeNode constructTree(int[] nums, int start, int end) {
            if (start == end) {
                return new TreeNode(nums[start], start, end);
            }
            TreeNode left = constructTree(nums, start, (start + end) / 2);
            TreeNode right = constructTree(nums, (start + end) / 2 + 1, end);
            TreeNode node = new TreeNode(left.val + right.val, start, end);
            node.left = left;
            node.right = right;
            return node;
        }

        void update(int i, int val) {
            if (root == null || root.low > i || root.up < i)
                return;
            updateRecursive(root, i, val);
        }

        private int updateRecursive(TreeNode node, int index, int val) {
            if (node.low == index && node.up == index) {
                int diff = val - node.val;
                node.val = val;
                return diff;
            }
            int diff;
            if (node.left.up < index) {
                diff = updateRecursive(node.right, index, val);
            } else {
                diff = updateRecursive(node.left, index, val);
            }

            node.val += diff;
            return diff;
        }

        public int sumRange(int i, int j) {
            if (i > j) {
                return sumRange(j, i);
            }
            return sumRangeRecursive(root, i, j);
        }

        private int sumRangeRecursive(TreeNode node, int low, int up) {
            if (node.low == low && node.up == up) {
                return node.val;
            }
            int mid = (node.up + node.low) / 2;
            if (up <= mid) {
                return sumRangeRecursive(node.left, low, up);
            } else if (low > mid) {
                return sumRangeRecursive(node.right, low, up);
            } else {
                return sumRangeRecursive(node.left, low, mid) + sumRangeRecursive(node.right, mid + 1, up);
            }
        }

        private class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            int low;
            int up;

            TreeNode(int value, int lowBound, int upBound) {
                val = value;
                low = lowBound;
                up = upBound;
            }
        }
    }
}
