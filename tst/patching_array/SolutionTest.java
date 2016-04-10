package patching_array;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.minPatches(new int[]{1, 5, 10}, 20));
    }
}
