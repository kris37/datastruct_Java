package punch.day16.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-18 09:08
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     最长等差序列
 *
 * <br>
 */
public class Leetcode1027_LAS {

    /**
     *
     * @param A
     * @return
     */
    public int longestArithSeqLength(int[] A) {
        if(A.length < 3) return A.length;
        // todo 使用数组
        // 假设存在 m < i 使得 A[j] - A[i] = A[i] - A[m] => A[m] = 2 *A[i] - A[j]
        // 又因为 A[x] >=0 = > 2 * A[i] - A[j] >=0 是必要不充分条件
        int maxNum = Integer.MIN_VALUE;
        for (int num : A) {
            maxNum = Math.max(maxNum,num);
        }

        int max = 0;
        // dp[i][j] 表示 以 i,j 为最后两个的等差数列的长度
        int[][] dp = new int[A.length][A.length];
        int [] pos = new int[maxNum +1];// 记录 A 中的某个数 num 在 A 中的索引 A[x] = i if(x mutiple,i is MIN(ALL i))
        Arrays.fill(pos,-1);


        for (int i = 0; i < A.length ; i++) {
            for (int j = i+1; j < A.length ; j++) {
                int num = A[i] - (A[j] - A[i]);
                // 假设存在 m < i 使得 A[j] - A[i] = A[i] - A[m] => A[m] = 2 *A[i] - A[j]
                // 又因为 A[*] >=0 = > 2 * A[i] - A[j] >=0 是必要不充分条件
                // 查找 当前 pos[k] 的 等差数列长度
                if(num>=0 && num <maxNum ){
                    // 可能存在 num
                    if(pos[num] == -1) continue;
                    dp[i][j] = dp[pos[num]][i] + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
            pos[A[i]] = i;
        }
        return max + 2;

    }

    public static void main(String[] args){
        int [] nums = {3,6,9,12};
        new Leetcode1027_LAS().longestArithSeqLength(nums);
    }

}
