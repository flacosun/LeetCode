import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/13/2016.
 */
public class AdditiveNumberTest {

    @Test
    public void test() {
        AdditiveNumber a = new AdditiveNumber();
        AdditiveNumber.Solution s = a.new Solution();
        assertTrue(s.isAdditiveNumber("199100199"));
    }
}