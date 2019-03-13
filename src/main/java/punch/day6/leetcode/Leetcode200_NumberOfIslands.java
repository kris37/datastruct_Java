package punch.day6.leetcode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-13 08:59
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 * <br>
 */
public class Leetcode200_NumberOfIslands {

    /**
     *  思路 借助DFS
     *  count
     *  遍历 grid 每一列,
     *  col in foreach:
     *      for p in col:
     *          if (p == 1):
     *              count++;
     *              DFS(p)
     *
     *
     * Runtime: 3 ms, faster than 99.99% of Java online submissions for Number of Islands.
     * Memory Usage: 40.9 MB, less than 64.25% of Java online submissions for Number of Islands.
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int cols = grid.length;
        int rows = cols == 0?0: grid[0].length;
        int count = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j <rows ; j++) {
                int p = grid[i][j];
                if(p == '1'){
                    count ++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int col,int row){
        int cols = grid.length;
        int rows = cols == 0?0: grid[0].length;
        if(col <0 || row < 0 || row >= rows || col >= cols || grid[col][row] == '0' ) return;
        grid[col][row] = '0';
        for ( int i = 0;i < 4;i++){
            //up
            dfs(grid,col,row -1);
            dfs(grid,col,row+1);
            dfs(grid,col-1,row);
            dfs(grid,col+1,row);
        }
    }

}
