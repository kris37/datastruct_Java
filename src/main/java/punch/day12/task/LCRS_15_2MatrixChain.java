package punch.day12.task;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-04 09:52
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     LCRS 15.2 矩阵链乘法
 *     for i in range(0,n-1):
 *
 *     思路就是 选择一个矩阵 i,假设i 是将整个矩阵链 分开的乘积最优解,那么 dp[0][i] + dp[i+1][n-1] + matrix[0]*matrix[i+1][n]就是最小的
 *     继续解决子问题
 * <br>
 */
public class LCRS_15_2MatrixChain {
    /**
     *  matrix 记录矩阵的行列数
     *  Ai 行 matrix[i] 列matrix[i+1]
     * @param matrix
     */
    public void problem(int [] matrix){

    }

    public int solution(int[] matrix,int n){
        int[][] dp = new int[n][n];

        //状态转 移方程 m = j - i
            for (int i = n-1; i >= 0  ; i--) {
                for (int j = i+1; j < n ; j++) {
                    int min = Integer.MAX_VALUE;
                    int cut = -1;
                    for (int k = i; k < j ; k++) {
                        min = Math.min(dp[i][k] + dp[k+1][j] + matrix[i] * matrix[k+1] * matrix[j+1],min);
                    }
                    dp[i][j] = min;
                }
            }
        for (int[] ints : dp) {
            for (int i : ints) {
                System.out.print(i+ "->");
            }
            System.out.println("");
        }
            return dp[0][n-1];

    }

    public static void main(String [] args) {
        int [] matrix = {30,35,15,5,10,20,25};
        LCRS_15_2MatrixChain dp = new LCRS_15_2MatrixChain();
        System.out.print(dp.solution(matrix,matrix.length -1));
    }


}
