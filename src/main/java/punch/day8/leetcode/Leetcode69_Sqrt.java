package punch.day8.leetcode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-03-30 22:49
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     牛顿迭代法
 *     f(x) = x^2 - n =0 的解
 *     f'(x) = f(N)/N - N.1 => Nx+1 = N - f(N)/f'(N)
 * <br>
 */
public class Leetcode69_Sqrt {

    public int mySqrt(int x) {
        double cur = x;
        while (Math.abs(Math.pow(cur,2) - x) >= 1){
            cur = cur/2 + 0.5*x/cur;
        }
        return (int)Math.floor(cur);
    }

    public static void main(String [] args ){
        Leetcode69_Sqrt leetcode69_sqrt = new Leetcode69_Sqrt();
        System.out.print(leetcode69_sqrt.mySqrt(2147395599));
    }
}
