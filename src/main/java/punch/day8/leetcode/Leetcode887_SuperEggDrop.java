package punch.day8.leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-29 20:30
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     抛鸡蛋问题
 *
 * <br>
 */
public class Leetcode887_SuperEggDrop {

    /**
     *
     * @param K 鸡蛋个数
     * @param N 楼层数
     * @return
     */
    public int superEggDrop(int K, int N) {
        int[][] memory = new int[K+1][N+1];

        return recursive(K,N);
    }

    /**
     *  若鸡蛋碎 dp(egg-1,i-1)
     *  不碎 dp(egg,n-i)
     *  //todo memory
     * @param egg
     * @param n
     * @return
     */
    private int dp(int egg,int n,int[][] memory){
        if(egg == 1 || n<=1) return n;
        if(memory[egg][n] > 0) return memory[egg][n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            min =Math.min(Math.max(dp(egg,n-i,memory),dp(egg-1,i-1,memory))+1 ,min);
        }
        memory[egg][n] = min;
        return min;
    }

    private int recursive(int egg,int n){
        if(egg == 1 || n<=1) return n;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n ; i++) {
            min =Math.min(Math.max(recursive(egg,n-i),recursive(egg-1,i-1))+1 ,min);
        }
        return min;
    }

    public static void main(String[] args){
        Leetcode887_SuperEggDrop dp = new Leetcode887_SuperEggDrop();
        System.out.print(dp.superEggDrop(6,10));

    }
}
