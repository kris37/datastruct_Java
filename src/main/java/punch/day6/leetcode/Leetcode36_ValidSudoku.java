package punch.day6.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-13 11:15
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     Runtime: 12 ms, faster than 98.71% of Java online submissions for Valid Sudoku.
 * Memory Usage: 46.3 MB, less than 35.83% of Java online submissions for Valid Sudoku.
 * <br>
 */
public class Leetcode36_ValidSudoku {
    /**
     * 思路：
     * 就是找是否出现过 bitmap hashset 思路即可
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        // default is all false
        final char dot = '.';
        final char one = '1';
        boolean [][] rows = new boolean[9][9];
        boolean [][] cols = new boolean[9][9];
        boolean [][] blocks = new boolean[9][9];

        for (int i = 0;i < 9;i++) {
            Arrays.fill(rows[i], true);
            Arrays.fill(cols[i], true);
            Arrays.fill(blocks[i], true);
        }

        // cols
        for (int i = 0; i <9 ; i++) {
            // rows
            for (int j = 0; j <9 ; j++) {
                if(board[i][j] != dot){
                    // board[i][j] => 映射到 rows，cols，blocks 三张表中
                    int num = board[i][j] - one;
                    if(rows[j][num] && cols[i][num] && blocks[getBlock(i,j)][num]){
                        rows[j][num] = cols[i][num] = blocks[getBlock(i,j)][num] = false;
                    }else{
                        return false;
                    }
                }
            }

        }

        return true;
    }

    private static int getBlock(int col,int row){
        return col/3 + (row/3) * 3;
    }

    public static void main(String [] args){
        char [][] chars = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.print(isValidSudoku(chars));
    }

}
