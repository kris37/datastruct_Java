package punch.day7.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-26 09:26
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * 零钱兑换
 * 无限背包问题
 * <br>
 */
public class Leetcode332_CoinChange {

    /**
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[]memory = new int[amount+1];
        Arrays.fill(memory,-1);
        memory[0] = 0;
        for (int coin : coins) {
            memory[coin] = 1;
        }
        int times = dp(amount,coins,memory);
        if(times == Integer.MAX_VALUE) return -1;
        return times;

    }

    private int dp(int tar,int[] coins,int[] memory){
        //select which
        if(memory[tar] >= 0) return memory[tar];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if(coin <= tar) {
                int select = dp(tar - coin, coins, memory);
                if(select == Integer.MAX_VALUE) continue;
                min = Math.min(select+1,min);
            }
        }
        memory[tar] = min;
        return min;
    }
}
