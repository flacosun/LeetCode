import java.util.Arrays;
import java.util.Map;

/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 * Created by Xiangqing Sun <xq.sun@uci.edu> on 4/14/2016.
 */
public class CoinChange {

    public class Solution {

        Map<Integer, Integer> dp;

        public int coinChange(int[] coins, int amount) {
            if (amount <= 0 && coins.length == 0) {
                return -1;
            }
            int[] dp = new int[amount + 1];

            Arrays.sort(coins);

            for (int i = 1; i <= amount; i++) {
                int min = -1;
                for (int coin : coins) {
                    if (i < coin) break;
                    if (dp[i - coin] != -1) {
                        min = min == -1 ? dp[i - coin] + 1 : Math.min(min, dp[i - coin] + 1);
                    }
                }
                dp[i] = min;
            }

            return dp[amount];
        }
    }
}
