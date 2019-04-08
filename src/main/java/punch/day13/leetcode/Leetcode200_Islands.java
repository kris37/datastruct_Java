package punch.day13.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *
 * <br>
 */
public class Leetcode200_Islands {

    public int numIslands(char[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length ; i++) {
            for (int j = 0,l = grid[i].length; j < l; j++) {
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    total +=1;
                }
            }
        }
        return total;
    }



    private void dfs(int x ,int y,char[][] grid){
        //if(grid[x][y] == '0') return ;
        grid[x][y] = '0';
        // up
        if(y - 1 >=0 && grid[x][y-1] == '1') dfs(x,y-1,grid);
        //down
        if(y+1 < grid[0].length && grid[x][y+1] == '1') dfs(x,y+1,grid);
        //left
        if(x -1 >= 0 && grid[x-1][y] == '1') dfs(x-1,y,grid);
        //right
        if(x + 1 < grid.length && grid[x+1][y] == '1') dfs(x+1,y,grid);
    }
}
