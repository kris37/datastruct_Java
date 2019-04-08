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
public class Leetcode72_EditDIstance {

    public int minDistance(String word1, String word2) {
        //return dpfunction(word1,word2);
         int[][] memory = new int[word1.length()][word2.length()];
        for (int[] ints : memory) {
            Arrays.fill(ints,-1);
        }
        return dpRecursive(0,0,word1,word2,memory);
    }

    /**
     * convert w1 => w2
     * operation delete replace insert
     * 状态转移方程
     * dp[i][j] 表示截止w1 字符 i 转移为 w2 的 j 需要的最小操作数
     *
     * dp[i][j] =min {dp[i-1][j]+1 将i-1 转为 j,删除 第i个字符
     *                 dp[i][j-1] +1 将 i 转为 j-1,再添加一个j的字符,
     *                 dp[i-1][j-1] +1 i-1 转到 j-1 ,replace i -> j
     *
     * }
     * @return
     */
    private int dpfunction(String w1,String w2){
        int[][] dp = new int[w1.length()+1][w2.length()+1];
        for (int i = 0; i <= w1.length() ; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= w2.length() ; j++) {
            dp[0][j] = j;
        }

        // 确定好方向 x - z
       //           | \
        //         y  cur

        for (int i = 0; i < w1.length() ; i++) {
            for (int j = 0; j < w2.length() ; j++) {
                if(w1.charAt(i) == w2.charAt(j)){
                    dp[i+1][j+1] =  dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j],dp[i][j+1]),dp[i+1][j]) +1;
                }
            }
        }
        return dp[w1.length()+1][w2.length()+1];
    }

    private int dpRecursive(int i,int j,String w1,String w2,int[][] memory){
        if(i == w1.length()) return w2.length() - j;
        if(j ==  w2.length()) return w1.length() - i;
        if(memory[i][j] > 0) return memory[i][j];

        if(w1.charAt(i) == w2.charAt(j)) {
            memory[i][j] = dpRecursive(i+1,j+1,w1,w2,memory);
        }else {
            memory[i][j] = Math.min(Math.min(dpRecursive(i,j+1,w1,w2,memory),
                    dpRecursive(i+1,j,w1,w2,memory)),
                    dpRecursive(i+1,j+1,w1,w2,memory)) + 1;
        }

        return memory[i][j];
    }
}
