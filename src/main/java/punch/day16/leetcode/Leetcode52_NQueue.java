package punch.day16.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-17 16:38
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     n-queue n皇后问题
 *     返回 可以解决n皇后的解法个数
 * <br>
 */
public class Leetcode52_NQueue {

    private int count = 0;
    public int totalNQueens(int n) {
        dfs(0,0,0,0,n);
        return count;
    }


    /**
     *
     * @param i
     * @param col 记录 列的占用
     * @param lv 记录 由于 左斜的占位
     * @param rv 记录 右斜的占位
     * @return
     */
    private void dfs(int i,int col,int lv,int rv,int n){
        if(i >= n){
            count++;
            return;
        }
        int bits = (~(col | lv | rv)) & ( (1 <<n) -1);
        // bits 1 为可选 位置 从后往前走
        while (bits > 0){
            //取最右边的1
            int pos = bits&(-bits);
            dfs(i+1,col|pos,(lv|pos) <<1,(rv|pos) >>1 ,n);
            bits &= bits - 1;
        }
    }
}
