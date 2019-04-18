package punch.day15.task;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @author panqiang37@gmail.com
 * @version punch
 * Date: 2019-04-13 11:08
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     catalan number 问题
 *
 * <br>
 */
public class CatalanNumber {
    public LinkedList<String> fs = new LinkedList<>();

    public String stackIO(int[] nums){
        int[] res = new int[nums.length];

        rf(0,0,0,nums,new LinkedList<Integer>(),0,res);
        return fs.toString();
    }

    private void rf(int in,int out,int index , int [] nums, LinkedList<Integer> stack,int i,int [] res){
        if(out == nums.length && in == nums.length){
            fs.add(mkString(res));
            return;
        }

        if(in > out){
            //
            Integer pop = stack.pop();
            res[i] = pop;
            rf(in,out + 1,index,nums,stack,i+1,res);
            stack.push(pop);
        }

        if(in < nums.length){
            stack.push(nums[index]);
            rf(in + 1,out,index + 1,nums,stack,i,res);
            stack.pop();
        }
    }

    private static String mkString(int []nums){
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(',');
        }
        return sb.toString();
    }

    public static void main(String [] args){
        CatalanNumber catalanNumber = new CatalanNumber();
        int [] num = {1,2,3};
        String s = catalanNumber.stackIO(num);
        System.out.println(s);
    }
}

