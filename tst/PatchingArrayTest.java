import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/10/2016.
 */
public class PatchingArrayTest {

    @Test
    public void test() {
        PatchingArray p = new PatchingArray();
        PatchingArray.Solution s = p.new Solution();
        assertEquals(2, s.minPatches(new int[]{1, 5, 10}, 20));
    }
}
