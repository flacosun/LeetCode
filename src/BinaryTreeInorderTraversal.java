import Types.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/26/2016.
 */
public class BinaryTreeInorderTraversal {

    public class Solution {

        // Morris in-order
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            TreeNode current = root;
            while (current != null) {
                if (current.left == null) {
                    result.add(current.val);
                    current = current.right;
                } else {
                    TreeNode rightMost = current.left;
                    while (rightMost.right != null && rightMost.right != current) {
                        rightMost = rightMost.right;
                    }
                    if (rightMost.right == null) {
                        rightMost.right = current;
                        current = current.left;
                    } else {
                        rightMost.right = null;
                        result.add(current.val);
                        current = current.right;
                    }
                }
            }

            return result;
        }
    }
}
