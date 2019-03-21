package punch.day7.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-20 12:28
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     583. Delete Operation for Two Strings
 * <br>
 */
public class Leetcode583_LCS {

    /**
     * 最长公共子序列类似
     * 都是Edit Distance的子问题 这里的operation 只有一个delete
     * @param word1
     * @param word2
     * @return
     */
    private String w1 ,w2 ;
    public int minDistance(String word1, String word2) {
        int[][] memory = new int[word1.length()][word2.length()];
        for (int[] ints : memory) {
            Arrays.fill(ints,-1);
        }

        w1 = word1;
        w2 = word2;
        return dp(0,0,memory);
    }

    private int dp(int x,int y,int[][] memory){
        if(x >= w1.length())  return w2.length() - y;
        if(y >= w2.length())  return w1.length() - x;
        if(memory[x][y] >= 0) return memory[x][y];
        if(w1.charAt(x) == w2.charAt(y)){

             memory[x][y] = dp(x+1,y+1,memory);
             return memory[x][y];
        }
        if(memory[x][y] >= 0) return memory[x][y];
        int deleteX = 1 + dp(x+1,y,memory);
        int deleteY = 1 + dp(x,y+1,memory);
        int deleteXY = 2 + dp(x+1,y+1,memory);


        if(deleteX > deleteY){
            memory[x][y] = Math.min(deleteY,deleteXY);
        }else {
            memory[x][y] = Math.min(deleteX,deleteXY);
        }

        return memory[x][y];


    }
}
