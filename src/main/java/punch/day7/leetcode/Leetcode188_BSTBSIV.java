package punch.day7.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-27 21:25
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode188_BSTBSIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length <= 1 || k<=0 ) return 0;
        if (k > (prices.length /2)) return quickI(prices);
        int[][][] memory = new int[2][k+1][prices.length];
        for (int[][] ints : memory) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        return dp(false,k,0,prices,memory);
    }

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

    private int quickI(int[] prices){
        int left = 0,right = 0 ,profit = 0;
        while (right < prices.length){
            while (right + 1 < prices.length &&
                    prices[right+1] > prices[right]){
                right++;
            }
            profit+= prices[right] - prices[left];
            left = ++right;
        }
        return profit;
    }
}
