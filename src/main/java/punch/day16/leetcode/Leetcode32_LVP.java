package punch.day16.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-17 17:19
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 *     //longest valid parentheses
 *     //最长有效括号
 * <br>
 */
public class Leetcode32_LVP {
    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    /**
     *  tle
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s.length() <= 1) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char [] sch = s.toCharArray();

        int max = -1;

        // 遍历 i,j  j > i
        /**状态转移方程
         *  if( ((j-i)&1) ==1 && @i == LEFT && @j == RIGHT){
         *  dp[i][j] = j - i==1?true:dp[i+1][j-1];
         *  }else{
         *      dp[i][j] = false;//default is false;//todo delete
         *  }
         *
         */

        for (int j = 0; j < s.length() ; j++) {
            for (int i = j-1; i >= 0 ; i--) {
                // 逻辑不清晰// k in (i,j) 之间 是否存在 dp[i][k] ==true and dp[k+1][j] == true
                if( ((j-i)&1) ==1 && sch[i] == LEFT && sch[j] == RIGHT){
                    //  find index form [i+1 to j-1]
                    if(j - i == 1){
                        dp[i][j] = true;
                    }else {
                        if(dp[i+1][j-1]){
                            dp[i][j] = true;
                        }else {
                            int k = i+1;
                            while (k <= j-1 && !dp[i][k]){
                                k++;
                            }
                            dp[i][j]= dp[i][k] && dp[k+1][j];
                        }
                    }
                }
                // 记录 i,j 最大范围
                if(dp[i][j] && max < j - i ){
                    max = j - i;
                }
            }
        }

        return max +1;
    }


    /**
     * dp[i] 以第i个字符为结尾的 最长的有效括号数目
     *
     * if(@i == '(') dp[i] =0 ; return;
     * if(@i == ')' && @i-1 == '(') dp[i] = dp[i-2] + 2; return;
     * else  @(i - dp[i-1] -1) == '(' dp[i] = dp[i-1] + 2 + dp[i-dp[i-1] -2]
     * @param s
     */

    public int longestValidParentheses1D(String s) {
        if (s.length() <= 1) return 0;
        int [] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if(s.charAt(i) == LEFT) continue;
            if(s.charAt( i -1 ) == LEFT){
                dp[i] = (i < 2?0:dp[i-2]) + 2;
            } else{
                if(i >= dp[i-1] + 1 && s.charAt(i - dp[i-1] -1) == LEFT ){
                    dp[i] = dp[i-1] + 2 + ((i - dp[i-1] -2) >= 0?dp[i - dp[i-1] -2]:0);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;

    }


    public static void main(String [] args){
        Leetcode32_LVP leetcode32_lvp = new Leetcode32_LVP();
        leetcode32_lvp.longestValidParentheses(")()())");

    }
}
