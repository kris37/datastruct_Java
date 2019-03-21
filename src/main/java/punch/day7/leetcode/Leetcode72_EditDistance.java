package punch.day7.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-19 21:40
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 * <br>
 */
public class Leetcode72_EditDistance {

    /**
     * min(cost(insert,replace,delete))
     * memory
     * 每个操作 复杂度 + 1
     * @param word1
     * @param word2
     * @return
     */
    private String w1 = null, w2 = null;
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0;
        w1 = word1;
        w2 = word2;
        int[][] memory = new int[w1.length()][w2.length()];
        for (int[] ints : memory) {
            Arrays.fill(ints,-1);
        }
        return dp(0,0, memory);
    }

    /**
     * 并不实际更改 word1 模拟处理
     * @return
     */
    private int dp(int index1 ,int index2,int[][] memory){

        if(index1 >= w1.length()) return w2.length() - index2;
        if(index2 >= w2.length()) return w1.length()-index1;

        if(memory[index1][index2] >= 0) return memory[index1][index2];
        if(w1.charAt(index1) == w2.charAt(index2)) {
            return dp(index1 +1,index2 +1,memory);
        }
        int insert = dp(index1,index2 +1,memory) + 1;
        int delete = dp(index1+1,index2,memory) +1;
        int replace = dp(index1 +1,index2+1,memory) +1;

        if(insert> delete){
            memory[index1][index2] = Math.min(delete,replace);

        }else {
            memory[index1][index2] = Math.min(insert,replace);
        }
        return   memory[index1][index2];
    }
}
