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
//        int total = 0;
//        for (int i = 0; i < grid.length ; i++) {
//            for (int j = 0,l = grid[i].length; j < l; j++) {
//                if(grid[i][j] == '1'){
//                    dfs(i,j,grid);
//                    total +=1;
//                }
//            }
//        }
//        return total;

        return unionFind(grid);
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


    /**
     * 并查集解决
     * 连通子图问题
     * @return
     */
    private int unionFind(char[][] grid){
        int[] roots = new int[grid.length * grid[0].length];
        int m = grid.length;// cols
        int n = grid[0].length;// rows
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    total ++;
                    // right
                    if(i+1 < m && grid[i+1][j] == '1'){
                        total -= union(roots,i * n + j,(i+1) * n +j);
                    }
                    //down
                    if(j+1 < n && grid[i][j+1] == '1'){
                        total -=union(roots,i * n + j,i * n +j +1);
                    }
                }

            }
        }
        return total;
    }

    /**
     *
     * @param roots
     * @param x
     * @return
     */
    private int getRoot(int[] roots,int x){
        while (x!=roots[x]){
            x = roots[x];
        }
        return x;
    }


    /**
     *  合并
     *  这里简单的采用随机数来进行 rank 处理
     * @param roots
     * @param x
     * @param y
     */
    private int union(int[] roots,int x,int y){
        int rootx = getRoot(roots, x);
        int rooty = getRoot(roots, y);
        if(rootx == rooty) return 0;

        if(Math.random() > 0.5F){
            roots[rootx] = rooty;
        }else {
            roots[rooty] = rootx;
        }
        return 1;
    }
}
