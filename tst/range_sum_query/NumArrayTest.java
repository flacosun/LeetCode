package range_sum_query;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/9/2016.
 */
public class NumArrayTest {
    @Test
    public void test() throws Exception {
        NumArray a = new NumArray(new int[]{1, 3, 5});
        assertEquals(9, a.sumRange(0, 2));
        a.update(1, 2);
        assertEquals(8, a.sumRange(0, 2));
    }

    @Test
    public void testEmptyArray() throws Exception {
        NumArray a = new NumArray(new int[]{});
    }
}