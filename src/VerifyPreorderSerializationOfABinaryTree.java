/**
 * 331. Verify Preorder Serialization of a Binary Tree
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class VerifyPreorderSerializationOfABinaryTree {

    public class Solution {

        public boolean isValidSerialization(String preorder) {
            int degree = 1;
            int i;
            String[] nodes = preorder.split(",");
            for (i = 0; i < nodes.length; i++) {
                if (nodes[i].charAt(0) == '#' && nodes[i].length() == 1) {
                    degree--;
                } else {
                    degree++;
                }
                if (degree == 0) {
                    break;
                }
            }

            return i == nodes.length - 1;
        }
    }
}
