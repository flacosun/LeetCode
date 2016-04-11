import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class VerifyPreorderSerializationOfABinaryTreeTest {

    @Test
    public void test() {
        VerifyPreorderSerializationOfABinaryTree v = new VerifyPreorderSerializationOfABinaryTree();
        VerifyPreorderSerializationOfABinaryTree.Solution s = v.new Solution();

        assertTrue(s.isValidSerialization("9,#,92,#,#"));
    }
}