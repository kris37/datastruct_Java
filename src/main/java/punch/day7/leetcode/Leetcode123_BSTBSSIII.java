package punch.day7.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-27 08:49
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     买卖股票
 *     最多买卖交易两次
 *     每次卖都是要赚钱的
 * <br>
 */
public class Leetcode123_BSTBSSIII {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1 ) return 0;
        int[][][] memory = new int[2][3][prices.length];
        for (int[][] ints : memory) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        return dp(false,2,0,prices,memory);
    }


    /**
     *
     *add memory 朴素dp 加memory
     * @param hold true 持有股票 false 不持有
     * @param times 交易次数remains
     * @param index
     * @param prices
     * @return
     */
    private int dp(boolean hold,int times,int index,int[] prices,int[][][] memory){
        if(times <=0 || index >= prices.length ) return 0;
        int v = memory[hold?1:0][times][index];
        if(v >= 0) return v;
        int max = 0;
        if(hold){
            // 选择卖或者不卖
            max = Math.max(dp(false,times-1,index+1,prices,memory)+ prices[index],
                    dp(true,times,index+1,prices,memory));
        }else {
            // 选择买或者不买
            max = Math.max(dp(true,times,index+1,prices,memory) - prices[index],
                    dp(false,times,index+1,prices,memory));
        }
        memory[hold?1:0][times][index] = max;
        return max;
    }
}
