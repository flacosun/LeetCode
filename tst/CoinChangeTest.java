import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/14/2016.
 */
public class CoinChangeTest {

    @Test
    public void coinChange() throws Exception {
        CoinChange c = new CoinChange();
        CoinChange.Solution s = c.new Solution();
        assertEquals(20, s.coinChange(new int[]{186,419,83,408}, 6249));
    }

    @Test
    public void coinChange2() throws Exception {
        CoinChange c = new CoinChange();
        CoinChange.Solution s = c.new Solution();
        assertEquals(18, s.coinChange(new int[]{70,177,394,428,427,437,176,145,83,370}, 7582));
    }

}