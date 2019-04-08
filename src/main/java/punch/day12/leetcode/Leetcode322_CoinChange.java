package punch.day12.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode322_CoinChange {

    /**
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //return dpFunction(coins,amount);
        int [] memory = new int[amount+1];
        int v = dpRecursive(amount,coins,memory);
        return  v == Integer.MAX_VALUE?-1:v;
    }


    // function transform solve
    private int dpFunction(int[] coins, int amount){
        int[] dp = new int[amount +1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount ; i++) {
            for (int j = 0; j <coins.length ; j++) {
                if(i - coins[j] >=0)
                dp[i] =  Math.min(dp[i],dp[i- coins[j]] ==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[i- coins[j]] +1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount] ;

    }

    // memory + recursive solve

    private int dpRecursive(int tar,int[] coins,int [] memory){
        assert  tar >= 0;
        if(tar == 0) return 0;
        if(memory[tar] > 0 ) return memory[tar];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if( tar >= coin) {
              int v = dpRecursive(tar -coin,coins,memory);
              if(v == Integer.MAX_VALUE) continue;
              min = Math.min(min,v+1);
            }
        }
        memory[tar] = min;
        return min;
    }

}
