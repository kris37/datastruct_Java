package punch.day2.leetcode;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @version punch
 * Date: 2019-03-07 15:32
 * To change this template use File | Settings | File Templates.
 * Description:
 * <p>
 *     逆波兰表达式
 *
 *     求值
 *
 *     同样依靠调度场算法 将中序遍历 -> 生成逆波兰表达式（后序遍历）
 * <br>
 */
public class Leetcode150_EvaluateReversePolishNotation {

    /**
     * Runtime: 4 ms, faster than 98.00% of Java online submissions for Evaluate Reverse Polish Notation.
     * Memory Usage: 36.7 MB, less than 36.79% of Java online submissions for Evaluate Reverse Polish Notation.
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(- stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    stack.push((int)(1D/stack.pop() * stack.pop()));
                    break;
                default:
                    Integer v = Integer.valueOf(token);
                    stack.push(v);
                    break;
            }
        }
        return stack.pop();

    }



    // 调度场算法
    //符号 stack 栈 要pop 出所有优先级 ‘>’ current


}
