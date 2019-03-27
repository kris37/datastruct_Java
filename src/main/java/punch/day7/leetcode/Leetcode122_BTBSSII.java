package punch.day7.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-26 22:00
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode122_BTBSSII {


    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int left = 0,right = 0 ,profit = 0;
        while (right < prices.length){
            while (right + 1 < prices.length &&
                    prices[right] > prices[right]){
                right++;
            }
            profit+= prices[right] - prices[left];
            left = ++right;
        }
        return profit;
    }
}
