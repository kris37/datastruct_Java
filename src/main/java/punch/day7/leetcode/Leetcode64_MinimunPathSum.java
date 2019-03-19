package punch.day7.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-19 09:13
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 * <br>
 */
public class Leetcode64_MinimunPathSum {

    /**
     * m * n m is rows n is cols
     *  分析：
     *  1。两个选择 right or down （到达边界的时候只有一个选择）
     *  2。min(select right,select down)
     *  3. 同时记录records
     *
     * Runtime: 3 ms, faster than 99.31% of Java online submissions for Minimum Path Sum.
     * Memory Usage: 42.2 MB, less than 14.26% of Java online submissions for Minimum Path Sum.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if(grid.length ==0 ) return 0;
        int[][] memory = new int[grid.length][grid[0].length];
        for (int[] ints : memory) {
            Arrays.fill(ints,-1);
        }
        return dp(grid,0,0,memory);
    }

    /**
     *
     * memory 记录 (i,j),到 end 的最小sum
     * @param grid
     * @param i rows
     * @param j cols
     * @return min path
     */
    private int dp(int[][] grid,int i,int j,int[][] memory){
        if(j == grid.length -1 && i == grid[0].length -1){
            // end point
            return grid[j][i];
        }
        if(memory[j][i] >= 0){
            return memory[j][i];
        }
        if(j == grid.length -1){
            // 走到right ，则直接返回边界sum
            int sum = 0;
            for (int k = i; k < grid[0].length ; k++) {
                sum+=grid[j][k];
            }
            memory[j][i] = sum;
            return sum;
        }
        if(i == grid[0].length -1){
            //walk down 的边界
            int sum = 0;
            for (int k = j; k < grid.length ; k++) {
                sum+=grid[k][i];
            }
            memory[j][i] = sum;
            return sum;
        }
        //
        int down = grid[j][i] + dp(grid,i+1,j,memory);
        int right = grid[j][i] + dp(grid,i,j+1,memory);
        if(down  <= right){
            memory[j][i] = down;
        }else {
            memory[j][i] = right;
        }
        return memory[j][i];
    }
}
