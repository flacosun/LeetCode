import Utils.TreeNodeUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/26/2016.
 */
public class BinaryTreeInorderTraversalTest {

    @Test
    public void test() {
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        BinaryTreeInorderTraversal.Solution s = b.new Solution();
        List<Integer> list = s.inorderTraversal(TreeNodeUtils.constructFromStringArray(
                "1","#","2","3"
        ));

        assertEquals(Arrays.asList(1, 3, 2), list);
    }



}