package punch.day7.leetcode;

import javax.sound.sampled.Line;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-18 11:48
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     N 皇后问题
 *     1。回溯法 通过 boolean [][] 进行标记 运行玩一层后回填进入下一层
 *     2。位运算进行加速，技巧性太强 了解其中的技巧，跟着实现即可
 * <br>
 */
public class LeetCode51_NQueens {

    private static final char Q = 'Q';
    private static final char DOT = '.';

    /**
     *
     * Runtime: 3 ms, faster than 93.16% of Java online submissions for N-Queens.
     * Memory Usage: 39.4 MB, less than 41.43% of Java online submissions for N-Queens.
     *  boolean [][] 回溯
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        if(n < 1) return result;
        char [][] matrix = new char[n][n];
        for (char[] chars : matrix) {
            Arrays.fill(chars,DOT);
        }
        dfs(matrix,0,n,result);
        return result;
    }

    private void dfs(char[][] matrix,int row,int n,List<List<String>> result){
        if(row >= n){
            LinkedList<String> cur = new LinkedList<>();
            for (char[] chars : matrix) {
                cur.add(mkString(chars));
            }
            result.add(cur);
            return;
        }
        for (int i = 0; i < n ; i++) {
            if(isValid(matrix,row,i)) {
                matrix[row][i] = Q;
                dfs(matrix, row + 1, n, result);
                matrix[row][i] =DOT;
            }
        }
    }

    private boolean isValid(char [][] matrix,int row,int col){
        // check vertical && leftSlash && rightSlash
        for (int i = 0;i < matrix.length;i++){
            int dis = Math.abs(i-row);
            boolean check = matrix[i][col] == Q
                    || (col - dis >=0 && matrix[i][col - dis] == Q)
                    || (col + dis < matrix.length && matrix[i][col + dis] == Q);
            if(check) return false;
        }
        return true;
    }

    private String mkString(char[] chars){
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();

    }
}

