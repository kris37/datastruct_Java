package punch.day7.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-21 17:21
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 *    对于类似回文或者矩阵相乘的中间游离 dp
 *    通常的公式
 *    for k in range(i:j)
 *     dp(i,k) + dp(k+1,j) + cost
 *
 *     https://blog.csdn.net/magicbean2/article/details/71158084
 *     http://www.cnblogs.com/grandyang/p/4271456.html
 *
 *
 * <br>
 */
public class Leetcode132_PalindromePartitioningII {

    public int minCut(String s) {

        char[] chars = s.toCharArray();
        if(s==null || s.length() <= 1) return 0;
         boolean [][] memory = new boolean[s.length()][s.length()];
        int[] dp = new int[chars.length];

        return bottomUp(chars,memory,dp);
    }

    /**
     * 1. dp 转移方程 if dp[i][j] == true => 1. (dp[i-1][j+1] = chars[i-1] == char[j+1]) 2. dp[i+1][j-1] == true
     *               else dp[i-1][j+1] = false
     *
     * @return
     */
    /**
     * 双 memeory dp;
     * @return
     */
    public int bottomUp(char[] chars,boolean[][] memory,int []dp){
        for (int i = 0; i < chars.length ; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if(chars[i] == chars[j] && ( i - j < 2 || memory[j + 1][i - 1])){
                    memory[j][i] = true;
                    if(j > 0 ){
                        dp[i] = Math.min(dp[i],dp[j - 1]+1);
                    }else {
                        dp[i] = 0;
                    }
                }

            }
        }
        return dp[chars.length-1];
    }

    /**
     *  add memeory 但是超时 所以需要优化采用 bottom-up 的方法
     * @param start
     * @param end
     * @return
     */
    private int dp(int start,int end, char[] chars,int[][] memory ){
        if(memory[start][end] >=0) return memory[start][end];
        if(isPalindrome(start,end,chars,memory)){
            return 0;
        }
        int cost = end - start;
        for (int i = start; i < end ; i++) {
            cost = Math.min(dp(start,i,chars,memory) + dp(i+1,end,chars,memory) + 1,cost);
            if(cost == 0) break;
        }
        memory[start][end] = cost;
        return cost; //
    }

    private boolean isPalindrome(int start,int end, char[] chars,int[][] memory){
        // memory[start][end] >0 return false;
        // = 0 return true
        // else continue
        // 判断 start end 是否是偶数
        if(start == end ){
            memory[start][end] = 0;
            return true;
        }
        int i = start,j = end;
        if(((i - j + 1)&1) == 0){
            // 偶数
            i = (i + j) >> 1;
            j = i + 1;

        }else {
            // 奇数
            i = (i+j) >>1;
            j = i;
        }
        while (i >=0 && j < chars.length){
            if(chars[i] == chars[j]){
                memory[i][j] = 0;
                i--;
                j++;
            }else {
                break;
            }
        }
        return memory[start][end] == 0;
    }







    public static void main(String [] args){
        Leetcode132_PalindromePartitioningII obj = new Leetcode132_PalindromePartitioningII();

        System.out.println(obj.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
