package Utils;

import Types.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/26/2016.
 */
public class TreeNodeUtils {
    public static TreeNode constructFromStringArray(String... input) {
        if (input.length == 0) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        q.add(root);
        for (int i = 1; i < input.length; i += 2) {
            TreeNode node = q.poll();
            node.left = parseNode(input[i]);
            if (node.left != null) {
                q.add(node.left);
            }
            if (i < input.length - 1) {
                node.right = parseNode(input[i+1]);
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return root;
    }

    private static TreeNode parseNode(String s) {
        if (s.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s));
        }
    }
}
