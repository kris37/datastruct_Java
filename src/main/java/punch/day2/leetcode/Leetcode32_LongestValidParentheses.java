package punch.day2.leetcode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 *
 * @version punch
 * Date: 2019-03-07 13:30
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *  最长有效括号
 * <br>
 */
public class Leetcode32_LongestValidParentheses {
    private static final char LEFT = '(';
    private static final char RIGHT = ')';
    /**
     *
     * Runtime: 11 ms, faster than 70.50% of Java online submissions for Longest Valid Parentheses.
     * Memory Usage: 38.8 MB, less than 15.58% of Java online submissions for Longest Valid Parentheses.
     * @param s
     * @return
     *
     * todo 改进就是将 index stack换为数组处理，并且动态计算最大长度
     */
    public static int longestValidParentheses(String s) {

        if(s == null || s.length() < 2) return 0;

        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();

        for (char ch : chars){
            if(stack.isEmpty() || ch == LEFT){
                stack.push(ch);
                index.push(0);
            }else {
                char peek = stack.peek();
                if(peek == LEFT){
                    stack.pop();
                    int sum = 2;
                    // index 一直 pop 出 0 为止 sum+=pop push(sum)
                    while (!index.isEmpty()){
                        int pop = index.pop();
                        if(pop == 0) break;
                        sum+=pop;
                    }
                    //// 继续合并非 0 的直到 遇到 0 或者empty
                    while (!index.isEmpty() && index.peekFirst() > 0){
                        sum+= index.pop();
                    }
                    index.push(sum);

                }else {
                    stack.push(ch);
                    index.push(0);
                }
            }

        }

        int max = 0;
        for (Integer integer : index) {
            max = integer > max?integer:max;
        }
        return max;
    }

    // todo
    //  改进 将index 由stack 变为数组处理，并且动态计算最大值



    public static void main(String [] args){
        String test = ")()())()()(";
        System.out.println(longestValidParentheses(test));
    }
}
